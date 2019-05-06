package com.ansh.picArts.resource.response;

import com.ansh.picArts.web.ApiResponse;

import java.util.ArrayList;

/***
 * @link GoogleSearchResponse
 * @see com.ansh.picArts.resource.response.GoogleSearchResponse
 *
 */

public class GoogleSearchResponse extends ApiResponse {

    private ArrayList<ItemsBean> items;

    public ArrayList<ItemsBean> getItems() {
        return items;
    }


    public static class ItemsBean {
        /**
         * title : Mango - Wikipedia
         * link : https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/09251jfFilipino_foods_fruits_Bulacan_landmarksfvf_37.jpg/220px-09251jfFilipino_foods_fruits_Bulacan_landmarksfvf_37.jpg
         * image : {"contextLink":"https://en.wikipedia.org/wiki/Mango","height":165,"width":220,"byteSize":13336,"thumbnailLink":"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8UgnuoVtCjymfaFE_uGamamIe-oMOdCwOOKMIcIHplCL_uSFa6LRzzQ","thumbnailHeight":80,"thumbnailWidth":107}
         */

        private String title;
        private String link;
        private ImageBean image;

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public ImageBean getImage() {
            return image;
        }

        public static class ImageBean {
            /**
             * contextLink : https://en.wikipedia.org/wiki/Mango
             * height : 165
             * width : 220
             * byteSize : 13336
             * thumbnailLink : https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8UgnuoVtCjymfaFE_uGamamIe-oMOdCwOOKMIcIHplCL_uSFa6LRzzQ
             * thumbnailHeight : 80
             * thumbnailWidth : 107
             */

            private String contextLink;
            private int height;
            private int width;
            private int byteSize;
            private String thumbnailLink;
            private int thumbnailHeight;
            private int thumbnailWidth;

            public String getContextLink() {
                return contextLink;
            }

            public int getHeight() {
                return height;
            }

            public int getWidth() {
                return width;
            }

            public int getByteSize() {
                return byteSize;
            }

            public void setByteSize(int byteSize) {
                this.byteSize = byteSize;
            }

            public String getThumbnailLink() {
                return thumbnailLink;
            }

            public int getThumbnailHeight() {
                return thumbnailHeight;
            }

            public int getThumbnailWidth() {
                return thumbnailWidth;
            }
        }
    }
}
