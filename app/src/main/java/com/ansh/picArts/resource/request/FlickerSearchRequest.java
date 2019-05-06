package com.ansh.picArts.resource.request;

import com.ansh.picArts.enums.flicker.FApiType;
import com.ansh.picArts.enums.flicker.FContentType;
import com.ansh.picArts.enums.flicker.FEmptyJSON;
import com.ansh.picArts.enums.flicker.FPrivacyFilter;
import com.ansh.picArts.enums.flicker.FResponseFormat;
import com.ansh.picArts.enums.flicker.FSearchTYPE;
import com.ansh.picArts.web.ApiRequest;

public class FlickerSearchRequest extends ApiRequest {
    private String keyword;
    private FApiType apiType;
    private String apiKey;
    private int pageNo;
    private int perPageItem;
    private FResponseFormat responseFormat;
    private FEmptyJSON emptyJSON;
    private FSearchTYPE searchTYPE;
    private FContentType contentType;
    private FPrivacyFilter privacyFilter;


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public FApiType getApiType() {
        return apiType;
    }

    public void setApiType(FApiType apiType) {
        this.apiType = apiType;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPerPageItem() {
        return perPageItem;
    }

    public void setPerPageItem(int perPageItem) {
        this.perPageItem = perPageItem;
    }

    public FResponseFormat getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(FResponseFormat responseFormat) {
        this.responseFormat = responseFormat;
    }

    public FEmptyJSON getEmptyJSON() {
        return emptyJSON;
    }

    public void setEmptyJSON(FEmptyJSON emptyJSON) {
        this.emptyJSON = emptyJSON;
    }

    public FSearchTYPE getSearchTYPE() {
        return searchTYPE;
    }

    public void setSearchTYPE(FSearchTYPE searchTYPE) {
        this.searchTYPE = searchTYPE;
    }

    public FContentType getContentType() {
        return contentType;
    }

    public void setContentType(FContentType contentType) {
        this.contentType = contentType;
    }

    public FPrivacyFilter getPrivacyFilter() {
        return privacyFilter;
    }

    public void setPrivacyFilter(FPrivacyFilter privacyFilter) {
        this.privacyFilter = privacyFilter;
    }
}
