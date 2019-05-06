package com.ansh.picArts.enums.flicker;

public enum FEmptyJSON {
    EMPTY_JSON_ALLOW("1"), NON_EMPTY("2");
    private String value;

    FEmptyJSON(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
