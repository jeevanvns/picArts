package com.ansh.picArts.resource.request;

import com.ansh.picArts.enums.googleImage.ASFileType;
import com.ansh.picArts.enums.googleImage.ASImageSize;
import com.ansh.picArts.enums.googleImage.ASImageType;
import com.ansh.picArts.enums.googleImage.ASSearchType;
import com.ansh.picArts.web.ApiRequest;


public class GoogleSearchRequest extends ApiRequest {

    private String searchEngineId;
    private String apiKey;
    private int noOfSearchResult;
    private String searchKeyword;
    private int startIndex;
    private ASFileType fileType;
    private ASImageSize imageSize;
    private ASImageType imageType;
    private ASSearchType searchType;


    public String getSearchEngineId() {
        return searchEngineId;
    }

    public void setSearchEngineId(String searchEngineId) {
        this.searchEngineId = searchEngineId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public int getNoOfSearchResult() {
        return noOfSearchResult;
    }

    public void setNoOfSearchResult(int noOfSearchResult) {
        this.noOfSearchResult = noOfSearchResult;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public ASFileType getFileType() {
        return fileType;
    }

    public void setFileType(ASFileType fileType) {
        this.fileType = fileType;
    }

    public ASImageSize getImageSize() {
        return imageSize;
    }

    public void setImageSize(ASImageSize imageSize) {
        this.imageSize = imageSize;
    }

    public ASImageType getImageType() {
        return imageType;
    }

    public void setImageType(ASImageType imageType) {
        this.imageType = imageType;
    }

    public ASSearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(ASSearchType searchType) {
        this.searchType = searchType;
    }
}
