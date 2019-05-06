package com.ansh.picArts.resource.service;

import android.content.Context;

import com.ansh.picArts.resource.request.GoogleSearchRequest;
import com.ansh.picArts.resource.response.GoogleSearchResponse;
import com.ansh.picArts.web.ApiService;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class GoogleImageService extends ApiService<GoogleImageService.ImageSearchApi, GoogleSearchRequest, GoogleSearchResponse> {

    public GoogleImageService(Context context) {
        super(context);
    }

    @Override
    protected Class<ImageSearchApi> getAPI() {
        return ImageSearchApi.class;
    }

    @Override
    protected Call<GoogleSearchResponse> onExecute(ImageSearchApi api, GoogleSearchRequest request) {
        return api.imageSearch(
                request.getSearchKeyword(),
                request.getFileType().getValue(),
                request.getImageSize().getValue(),
                request.getImageType().getValue(),
                request.getNoOfSearchResult(),
                request.getSearchType().getValue(),
                request.getStartIndex(),
                request.getApiKey());
    }

    public interface ImageSearchApi {
        @GET("customsearch/v1?cx=013370013767250666571%3Aa3rpspnxpuu")
        Call<GoogleSearchResponse> imageSearch(
                @Query("q") String searchKeyword,
                @Query("fileType") String fileType,
                @Query("imgSize") String imageSize,
                @Query("imgType") String imageType,
                @Query("num") int noOfSearchResult,
                @Query("searchType") String searchType,
                @Query("start") int startIndex,
                @Query("key") String apiKey);
    }
}
