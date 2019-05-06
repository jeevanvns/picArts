package com.ansh.picArts.enums.flicker;

public enum FResponseFormat {
    JSON("json"), XML("xml");
    private String value;

    FResponseFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


