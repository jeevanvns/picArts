package com.ansh.picArts.utils;

import com.ansh.picArts.resource.response.FlickerImageResponse;

public class FlickerUtils {


    /**
     * @param bean Flicker Image Response item
     * @return Generated Url based on Secreat key,Id,Server Id etc.
     */
    public static String getUrl(FlickerImageResponse.PhotosBean.PhotoBean bean) {
        if (bean != null) {
            return "https://farm" + bean.getFarm() + ".static.flickr.com/" + bean.getServer() + "/" + bean.getId() + "_" + bean.getSecret() + ".jpg";
        }
        return null;
    }
}
