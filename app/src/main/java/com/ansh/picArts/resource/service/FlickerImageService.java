package com.ansh.picArts.resource.service;

import android.content.Context;

import com.ansh.picArts.resource.request.FlickerSearchRequest;
import com.ansh.picArts.resource.response.FlickerImageResponse;
import com.ansh.picArts.web.ApiService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class FlickerImageService extends ApiService<FlickerImageService.FlickerApi, FlickerSearchRequest, FlickerImageResponse> {


    public FlickerImageService(Context context) {
        super(context);
    }

    @Override
    protected Class<FlickerApi> getAPI() {
        return FlickerApi.class;
    }

    @Override
    protected Call<FlickerImageResponse> onExecute(FlickerApi api, FlickerSearchRequest request) {
        return api.getImage(request.getApiType().getValue(),
                request.getApiKey(),
                request.getResponseFormat().getValue(),
                request.getEmptyJSON().getValue(),
                request.getSearchTYPE().getValue(),
                request.getKeyword(),
                request.getContentType().getValue(),
                request.getPageNo(),
                request.getPerPageItem(),
                request.getContentType().getValue()
        );
    }

    public interface FlickerApi {
        @GET("/services/rest/")
        Call<FlickerImageResponse> getImage(@Query("method") String apiType,
                                            @Query("api_key") String apiKey,
                                            @Query("format") String responseFormat,
                                            @Query("nojsoncallback") String isAllowEmptyJSON,
                                            @Query("safe_search") int safeSearch,
                                            @Query("text") String keyword,
                                            @Query("content_type") int contentType,
                                            @Query("page") int page,
                                            @Query("per_page") int perPageLimit,
                                            @Query("privacy_filter") int privacyFilter);

    }
}
