package com.ansh.picArts.enums.googleImage;


/**
 * @author Jeevan Gupta
 * crated by 05/04/2019
 * @link ASImageSize
 */
public enum ASImageSize {

    ICON("icon"), SMALL("small"), MEDIUM("medium"), LARGE("large"), XLARGE("xlarge"), XXLARGE("xxlarge"), HUGE("huge");
    private String value;

    ASImageSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }}
