package com.ansh.picArts.enums.googleImage;

/**
 * @author Jeevan Gupta
 * crated by 05/04/2019
 * @link ASImageType
 */
public enum ASImageType {

    CLIPART("clipart"), FACE("face"), LINE_ART("lineart"), NEWS("news"), PHOTO("photo");
    private String value;

    ASImageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }}
