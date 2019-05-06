package com.ansh.picArts.web;




/*
 * * created by Jeevan Gupta 05/04/2019
 * {@link ApiRequest}
 */

import com.ansh.picArts.utils.AppConstant;

public abstract class ApiRequest {

    public boolean isValid() {
        return true;
    }

    public String getBaseUrl() {
        return AppConstant.SERVER_URL;
    }
}