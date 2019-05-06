package com.ansh.picArts.enums.googleImage;


/**
 * @author Jeevan Gupta
 * crated by 05/04/2019
 * @link ASFileType
 */
public enum ASFileType {

    BMP("bmp"), GIF("gif"), PNG("png"), JPG("jpg"), SVG("svg"), PDF("pdf");
    private String value;

    private ASFileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }}
