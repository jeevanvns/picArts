package com.ansh.picArts.enums.flicker;

public enum FApiType {
    SEARCH("flickr.photos.search");
    private String value;

    FApiType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
