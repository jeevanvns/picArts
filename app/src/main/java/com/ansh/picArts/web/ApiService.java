package com.ansh.picArts.web;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * created by Jeevan Gupta 05/04/2019
 * {@link ApiService}
 */

public abstract class ApiService<U, T extends ApiRequest, L extends ApiResponse> {


    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_PRAGMA = "Pragma";
    private static final int TIME_OUT = 60;

    /**
     * Use to build Gson object for serialization and deserialization of pojo
     */
    private static Gson sGson;

    private Context mContext;

    public ApiService(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    public final void execute(final T request, final ApiCallback<L> callback) {
        if (callback == null) {
//            throw new ApiException(ApiException.Kind.NULL, "Callback may not be null");
        } else if (getAPI() == null) {
            callback.onComplete();
            callback.onFailure(new ApiException(ApiException.Kind.NULL, "API Interface may not be null"));
        } else if (request == null) {
            callback.onComplete();
            callback.onFailure(new ApiException(ApiException.Kind.NULL, "Request may not be null"));
        } else if (!request.isValid()) {
            callback.onComplete();
            callback.onFailure(new ApiException(ApiException.Kind.INVALID_REQUEST, "Invalid request"));
        } else {
            String baseUrl = request.getBaseUrl();
            if (TextUtils.isEmpty(baseUrl)) {
                callback.onComplete();
                callback.onFailure(new ApiException(ApiException.Kind.NULL, "Base Url may not be null"));
                return;
            }
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addInterceptor(provideOfflineCacheInterceptor())
                    .addNetworkInterceptor(provideCacheInterceptor())
                    .cache(provideCache())
                    .connectTimeout(getConnectionTimeoutInSeconds(), SECONDS)
                    .readTimeout(getReadTimeoutInSeconds(), SECONDS);
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Call<L> call = ApiService.this.onExecute(retrofit.create(getAPI()), request);
                    call.enqueue(callback);
                }
            }).start();
        }
    }

    private Interceptor provideCacheInterceptor() {
        return chain -> {
            Response response = chain.proceed(chain.request());

            CacheControl cacheControl;

            if (isNetworkAvailable()) {
                cacheControl = new CacheControl.Builder()
                        .maxAge(0, TimeUnit.SECONDS)
                        .build();
            } else {
                cacheControl = new CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build();
            }

            return response.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                    .build();

        };
    }

    private Cache provideCache() {
        Cache cache = null;
        try {
            cache = new Cache(new File(mContext.getCacheDir(), "http-cache"), 10 * 1024 * 1024); // 10 MB
        } catch (Exception e) {
            Log.e(TAG, "Could not create Cache!");
        }
        return cache;
    }

    private Interceptor provideOfflineCacheInterceptor() {
        return chain -> {
            Request request = chain.request();

            if (!isNetworkAvailable()) {
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build();

                request = request.newBuilder()
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .cacheControl(cacheControl)
                        .build();
            }

            return chain.proceed(request);
        };
    }

    private Gson getGson() {
        if (sGson != null) {
            return sGson;
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        return sGson = gsonBuilder.create();
    }

    private int getConnectionTimeoutInSeconds() {
        return TIME_OUT;
    }

    private int getReadTimeoutInSeconds() {
        return TIME_OUT;
    }

    protected abstract Class<U> getAPI();

    /**
     * @param api     to pass data in request
     * @param request to send on server
     */
    protected abstract Call<L> onExecute(U api, T request);

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } else return false;
    }

}
