package com.ansh.picArts.enums.flicker;

public enum FSearchTYPE {
    SAFE(1), MODERATE(2), RESTRICTED(3);
    private int value;

    public int getValue() {
        return value;
    }

    FSearchTYPE(int value) {
        this.value = value;
    }
}
