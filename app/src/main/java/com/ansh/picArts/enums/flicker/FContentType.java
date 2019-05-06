package com.ansh.picArts.enums.flicker;

public enum FContentType {

    PHOTO(1), SCREEN_SHOTS(2), OTHER(3),
    PHOTO_AND_SCREEN_SHOOTS(4), SCREEN_SHOOTS_AND_OTHER(5),
    PHOTO_AND_OTHER(6), PHOTO_SCREEN_SHOT_OTHER(7);

    private int value;

    FContentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
