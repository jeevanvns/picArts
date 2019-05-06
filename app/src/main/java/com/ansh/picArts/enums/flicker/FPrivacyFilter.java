package com.ansh.picArts.enums.flicker;

public enum  FPrivacyFilter {

    PUBLIC(1), PRIVATE(2), PRIVATE_VISIBLE_FAIMALY(3),
    PRIVATE_VISIBLE_FRIEND_FAIMLY(4), COMPLETELY_PRIVATE(5);
    private int value;

    FPrivacyFilter(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
