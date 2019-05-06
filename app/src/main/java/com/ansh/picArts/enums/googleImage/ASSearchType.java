package com.ansh.picArts.enums.googleImage;

/**
 * @author Jeevan Gupta
 * crated by 05/04/2019
 * @link ASSearchType
 */

public enum ASSearchType {
    IMAGE("image");
    private String value;

    ASSearchType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }}
