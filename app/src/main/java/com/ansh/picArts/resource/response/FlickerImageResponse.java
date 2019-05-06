package com.ansh.picArts.resource.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.ansh.picArts.web.ApiResponse;

import java.util.ArrayList;


public class FlickerImageResponse extends ApiResponse {


    /**
     * photos : {"page":1,"pages":4579,"perpage":100,"total":"457813","photo":[{"id":"46864121115","owner":"147047514@N05","secret":"7823f07371","server":"65535","farm":66,"title":"panda","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864108705","owner":"170969929@N03","secret":"00e1530a51","server":"65535","farm":66,"title":"6548357235860549522","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814125533","owner":"71196443@N03","secret":"f6fb9578c2","server":"65535","farm":66,"title":"when the cat's away","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864100465","owner":"77174342@N02","secret":"f50775eb3f","server":"65535","farm":66,"title":"Kittens","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728224522","owner":"77174342@N02","secret":"5e5a5c0ee3","server":"65535","farm":66,"title":"Kittens","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991198044","owner":"77174342@N02","secret":"c89bce4145","server":"65535","farm":66,"title":"Kittens","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814123203","owner":"27653142@N07","secret":"06a5273b5d","server":"65535","farm":66,"title":"purrfect","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903362158","owner":"54686358@N00","secret":"29d0cb8cec","server":"65535","farm":66,"title":"letting the cat out of the box","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780399831","owner":"78517182@N07","secret":"66aa86654c","server":"65535","farm":66,"title":"Where are THE BIRDS ?","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780398651","owner":"170969929@N03","secret":"bcb29a23b0","server":"65535","farm":66,"title":"FB_IMG_1549556412121","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814114433","owner":"158421683@N08","secret":"d066201702","server":"65535","farm":66,"title":"Helping hand #cats #mobilephotography #lgg7thinq #photooftheday","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991179974","owner":"150008620@N05","secret":"149c874842","server":"65535","farm":66,"title":"_MG_8791-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836906437","owner":"154105164@N06","secret":"386633f80a","server":"65535","farm":66,"title":"20180329_03176-Bearbeitet.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903324558","owner":"12903817@N07","secret":"1bc1e01229","server":"65535","farm":66,"title":"2019.05.05 Kitten (phonetography)","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991164724","owner":"140007800@N06","secret":"b992b6b40f","server":"65535","farm":66,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814098453","owner":"140007800@N06","secret":"f9a585fb97","server":"65535","farm":66,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814093763","owner":"8070463@N03","secret":"9fe48e5252","server":"65535","farm":66,"title":"Two cubs playing","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991155244","owner":"35940835@N03","secret":"d09090893b","server":"65535","farm":66,"title":"2019-05-05 Wildpark Tambach","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991154834","owner":"35940835@N03","secret":"cd19e0b6f3","server":"65535","farm":66,"title":"2019-05-05 Wildpark Tambach","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728180812","owner":"35940835@N03","secret":"105db4df1d","server":"65535","farm":66,"title":"2019-05-05 Wildpark Tambach","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728156442","owner":"150008620@N05","secret":"d2fec41109","server":"65535","farm":66,"title":"_MG_8793-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728102552","owner":"150008620@N05","secret":"83ecfb3c39","server":"65535","farm":66,"title":"_MG_8794-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728044892","owner":"150008620@N05","secret":"54ba39153b","server":"65535","farm":66,"title":"_MG_8804-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780197731","owner":"150008620@N05","secret":"60d27c9651","server":"65535","farm":66,"title":"_MG_8809-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836872007","owner":"164230129@N02","secret":"e8a41f0856","server":"65535","farm":66,"title":"francefinalcontactsheet8","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864036745","owner":"165271339@N02","secret":"79a64339f1","server":"65535","farm":66,"title":"Liner zone","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814063963","owner":"77174342@N02","secret":"1305d9b1f4","server":"65535","farm":66,"title":"Oscar","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903285998","owner":"77174342@N02","secret":"ed026d5310","server":"65535","farm":66,"title":"Oscar","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780339421","owner":"77174342@N02","secret":"4897a2befb","server":"65535","farm":66,"title":"0012","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864027395","owner":"34013737@N06","secret":"4b6a4c0ca0","server":"65535","farm":66,"title":"Tiggy Grayson Tiggy Jr Cowsie","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903280278","owner":"77174342@N02","secret":"5a1a9f04ab","server":"65535","farm":66,"title":"0002","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903278288","owner":"163422581@N04","secret":"c08637d1b8","server":"65535","farm":66,"title":"Baby Amelia","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864023755","owner":"163799850@N04","secret":"cf3dc2053b","server":"65535","farm":66,"title":"Bill","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991107514","owner":"34013737@N06","secret":"c17c30b2c4","server":"65535","farm":66,"title":"Hello Tiggy Cowsie Grady","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903261338","owner":"124105016@N02","secret":"a654ce570b","server":"65535","farm":66,"title":"20190505-_DSC1541","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780304621","owner":"61660161@N08","secret":"42bcdd5c4f","server":"65535","farm":66,"title":"IMG_6868","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780302371","owner":"142266470@N02","secret":"1c87a2386a","server":"65535","farm":66,"title":"137_Sicilia 2019","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991099404","owner":"34013737@N06","secret":"d434b22028","server":"65535","farm":66,"title":"3  Cute Kitts","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836806017","owner":"91701539@N03","secret":"daf6828794","server":"65535","farm":66,"title":"Sur la route de Kanab- Utah- Etats-Unis.","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903227848","owner":"66210868@N08","secret":"fac86c404f","server":"65535","farm":66,"title":"Summertime Sadness","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780290161","owner":"13186010@N00","secret":"21cc6a047a","server":"65535","farm":66,"title":"Canon A-1-2019-1-2","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991078104","owner":"13186010@N00","secret":"aedbb352f2","server":"65535","farm":66,"title":"Canon A-1-2019-1-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780290241","owner":"165318893@N06","secret":"5b694646a0","server":"65535","farm":66,"title":"15 Simple Yet Stunning Hairstyle Tutorials for Lazy Women","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903182728","owner":"157726557@N03","secret":"7ef80e9379","server":"65535","farm":66,"title":"IMG_0686","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727883602","owner":"169881274@N05","secret":"2a81116cd4","server":"65535","farm":66,"title":"DSC03211","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813785293","owner":"169881274@N05","secret":"f110c437ed","server":"65535","farm":66,"title":"DSC03181","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903026908","owner":"169881274@N05","secret":"932b62c943","server":"65535","farm":66,"title":"DSC03182","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813784343","owner":"169881274@N05","secret":"496b0493a2","server":"65535","farm":66,"title":"DSC03183","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780246211","owner":"129323740@N08","secret":"ff9aa33ba3","server":"65535","farm":66,"title":"Kot","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813970733","owner":"164176290@N04","secret":"db53bbf955","server":"65535","farm":66,"title":"Ética animal, cultura de Paz y activismo académico; por Margarita Carretero González","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728068342","owner":"168565288@N03","secret":"d532f060bf","server":"65535","farm":66,"title":"Ética animal, cultura de Paz y activismo académico; por Margarita Carretero González","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728061732","owner":"100032311@N06","secret":"d6e2af80a7","server":"65535","farm":66,"title":"B&M No. 3713 THE CONSTITUTION (4-6-2) Class P-4-a enroute by car float from North Station to the Museum of Science, Boston and Cambridge, Mass., 1969","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728057772","owner":"107626825@N07","secret":"b548d29a74","server":"65535","farm":66,"title":"日本橋","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836740507","owner":"148057290@N06","secret":"913c5474bc","server":"65535","farm":66,"title":"DSC4900_DxO","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836727867","owner":"40680990@N08","secret":"7e3221225e","server":"65535","farm":66,"title":"Pepe","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836722207","owner":"165254451@N05","secret":"8ca16335e4","server":"65535","farm":66,"title":"_DSC9800","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863881195","owner":"94706054@N05","secret":"186bb312be","server":"65535","farm":66,"title":"Onion Bulb Boutique Faceup Collage","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813916263","owner":"151448152@N04","secret":"f6bf857762","server":"65535","farm":66,"title":"Literally 16","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813920973","owner":"152449808@N03","secret":"b9ec7c2ce2","server":"65535","farm":66,"title":"Merriweather_0462","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903155718","owner":"157579733@N07","secret":"0e491d7979","server":"65535","farm":66,"title":"Gecko cat?","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728007572","owner":"169928236@N06","secret":"b9f1215f76","server":"65535","farm":66,"title":"This is a baby tiger I saw in Phuket, Thailand. Decided to change the original to black and white because I felt the quality and the lighting of this picture looked better.","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780206521","owner":"151187872@N05","secret":"5ba9c9b7cd","server":"65535","farm":66,"title":"DSC08346","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836699857","owner":"146376068@N02","secret":"7eb1bc607a","server":"65535","farm":66,"title":"IMG_20190401_071035_192","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863852595","owner":"67089641@N05","secret":"52f302b293","server":"65535","farm":66,"title":"Jana","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863852555","owner":"67089641@N05","secret":"e46e32ba61","server":"65535","farm":66,"title":"Jana","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903146188","owner":"67089641@N05","secret":"b40ff2f855","server":"65535","farm":66,"title":"Jana","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836696147","owner":"44561865@N02","secret":"09130f9204","server":"65535","farm":66,"title":"DSCF5153.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990966254","owner":"44561865@N02","secret":"9eb43e7be5","server":"65535","farm":66,"title":"DSCF5092.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903139328","owner":"170999419@N03","secret":"247f5bf4f5","server":"65535","farm":66,"title":"How To Apply Foundation Like A Pro \u2013 Step By Step Guide","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990962404","owner":"151187872@N05","secret":"bcda7b8a60","server":"65535","farm":66,"title":"DSC08331","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863843845","owner":"151187872@N05","secret":"fa903c0df8","server":"65535","farm":66,"title":"DSC08337","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727988382","owner":"151187872@N05","secret":"fccba77b18","server":"65535","farm":66,"title":"DSC08340","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727988052","owner":"151187872@N05","secret":"042a51bbb1","server":"65535","farm":66,"title":"DSC08350","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987862","owner":"151187872@N05","secret":"ef192f996b","server":"65535","farm":66,"title":"DSC08356","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863843505","owner":"151187872@N05","secret":"e30b4c6c6d","server":"65535","farm":66,"title":"DSC08355","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987712","owner":"151187872@N05","secret":"9119d58199","server":"65535","farm":66,"title":"DSC08360","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987782","owner":"151187872@N05","secret":"87767d3f5a","server":"65535","farm":66,"title":"DSC08359","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990961284","owner":"151187872@N05","secret":"77b6a97911","server":"65535","farm":66,"title":"DSC08357","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987532","owner":"151187872@N05","secret":"66ccbcbd4f","server":"65535","farm":66,"title":"DSC08371","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813898783","owner":"151187872@N05","secret":"d73e64130a","server":"65535","farm":66,"title":"DSC08374","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987582","owner":"151187872@N05","secret":"b7033887ab","server":"65535","farm":66,"title":"DSC08366","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813898633","owner":"151187872@N05","secret":"89191f7fce","server":"65535","farm":66,"title":"DSC08383","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987462","owner":"151187872@N05","secret":"b8054403ae","server":"65535","farm":66,"title":"DSC08375","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990960454","owner":"151187872@N05","secret":"ec5f03e612","server":"65535","farm":66,"title":"DSC08387","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903137098","owner":"151187872@N05","secret":"4889cf7919","server":"65535","farm":66,"title":"DSC08402","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903136828","owner":"151187872@N05","secret":"3c15c8b019","server":"65535","farm":66,"title":"DSC08411","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990959704","owner":"151187872@N05","secret":"7586742ff7","server":"65535","farm":66,"title":"DSC08409","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986552","owner":"151187872@N05","secret":"1da9ab78d7","server":"65535","farm":66,"title":"DSC08412","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903136738","owner":"151187872@N05","secret":"770c058aa6","server":"65535","farm":66,"title":"DSC08416","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990959544","owner":"151187872@N05","secret":"f8bb73a2c1","server":"65535","farm":66,"title":"DSC08413","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986382","owner":"151187872@N05","secret":"483d0c6d92","server":"65535","farm":66,"title":"DSC08419","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986322","owner":"151187872@N05","secret":"bbea39feed","server":"65535","farm":66,"title":"DSC08421","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986272","owner":"151187872@N05","secret":"c8c0dd2be4","server":"65535","farm":66,"title":"DSC08426","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813897563","owner":"151187872@N05","secret":"2eab249d99","server":"65535","farm":66,"title":"DSC08333","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813897673","owner":"151187872@N05","secret":"5c2b758954","server":"65535","farm":66,"title":"DSC08422","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986142","owner":"151187872@N05","secret":"3554b8e0f9","server":"65535","farm":66,"title":"DSC08347","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986082","owner":"151187872@N05","secret":"b97e9716ff","server":"65535","farm":66,"title":"DSC08358","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990958554","owner":"151187872@N05","secret":"9286acb0a2","server":"65535","farm":66,"title":"DSC08384","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727985942","owner":"151187872@N05","secret":"ac5250345d","server":"65535","farm":66,"title":"DSC08376","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813896413","owner":"8426916@N04","secret":"9ea1a32a4d","server":"65535","farm":66,"title":"Beachwood Lion","ispublic":1,"isfriend":0,"isfamily":0}]}
     * stat : ok
     */

    private PhotosBean photos;
    private String stat;

    public PhotosBean getPhotos() {
        return photos;
    }

    public void setPhotos(PhotosBean photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public static class PhotosBean implements Parcelable {
        /**
         * page : 1
         * pages : 4579
         * perpage : 100
         * total : 457813
         * photo : [{"id":"46864121115","owner":"147047514@N05","secret":"7823f07371","server":"65535","farm":66,"title":"panda","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864108705","owner":"170969929@N03","secret":"00e1530a51","server":"65535","farm":66,"title":"6548357235860549522","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814125533","owner":"71196443@N03","secret":"f6fb9578c2","server":"65535","farm":66,"title":"when the cat's away","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864100465","owner":"77174342@N02","secret":"f50775eb3f","server":"65535","farm":66,"title":"Kittens","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728224522","owner":"77174342@N02","secret":"5e5a5c0ee3","server":"65535","farm":66,"title":"Kittens","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991198044","owner":"77174342@N02","secret":"c89bce4145","server":"65535","farm":66,"title":"Kittens","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814123203","owner":"27653142@N07","secret":"06a5273b5d","server":"65535","farm":66,"title":"purrfect","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903362158","owner":"54686358@N00","secret":"29d0cb8cec","server":"65535","farm":66,"title":"letting the cat out of the box","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780399831","owner":"78517182@N07","secret":"66aa86654c","server":"65535","farm":66,"title":"Where are THE BIRDS ?","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780398651","owner":"170969929@N03","secret":"bcb29a23b0","server":"65535","farm":66,"title":"FB_IMG_1549556412121","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814114433","owner":"158421683@N08","secret":"d066201702","server":"65535","farm":66,"title":"Helping hand #cats #mobilephotography #lgg7thinq #photooftheday","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991179974","owner":"150008620@N05","secret":"149c874842","server":"65535","farm":66,"title":"_MG_8791-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836906437","owner":"154105164@N06","secret":"386633f80a","server":"65535","farm":66,"title":"20180329_03176-Bearbeitet.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903324558","owner":"12903817@N07","secret":"1bc1e01229","server":"65535","farm":66,"title":"2019.05.05 Kitten (phonetography)","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991164724","owner":"140007800@N06","secret":"b992b6b40f","server":"65535","farm":66,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814098453","owner":"140007800@N06","secret":"f9a585fb97","server":"65535","farm":66,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814093763","owner":"8070463@N03","secret":"9fe48e5252","server":"65535","farm":66,"title":"Two cubs playing","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991155244","owner":"35940835@N03","secret":"d09090893b","server":"65535","farm":66,"title":"2019-05-05 Wildpark Tambach","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991154834","owner":"35940835@N03","secret":"cd19e0b6f3","server":"65535","farm":66,"title":"2019-05-05 Wildpark Tambach","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728180812","owner":"35940835@N03","secret":"105db4df1d","server":"65535","farm":66,"title":"2019-05-05 Wildpark Tambach","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728156442","owner":"150008620@N05","secret":"d2fec41109","server":"65535","farm":66,"title":"_MG_8793-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728102552","owner":"150008620@N05","secret":"83ecfb3c39","server":"65535","farm":66,"title":"_MG_8794-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728044892","owner":"150008620@N05","secret":"54ba39153b","server":"65535","farm":66,"title":"_MG_8804-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780197731","owner":"150008620@N05","secret":"60d27c9651","server":"65535","farm":66,"title":"_MG_8809-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836872007","owner":"164230129@N02","secret":"e8a41f0856","server":"65535","farm":66,"title":"francefinalcontactsheet8","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864036745","owner":"165271339@N02","secret":"79a64339f1","server":"65535","farm":66,"title":"Liner zone","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40814063963","owner":"77174342@N02","secret":"1305d9b1f4","server":"65535","farm":66,"title":"Oscar","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903285998","owner":"77174342@N02","secret":"ed026d5310","server":"65535","farm":66,"title":"Oscar","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780339421","owner":"77174342@N02","secret":"4897a2befb","server":"65535","farm":66,"title":"0012","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864027395","owner":"34013737@N06","secret":"4b6a4c0ca0","server":"65535","farm":66,"title":"Tiggy Grayson Tiggy Jr Cowsie","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903280278","owner":"77174342@N02","secret":"5a1a9f04ab","server":"65535","farm":66,"title":"0002","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903278288","owner":"163422581@N04","secret":"c08637d1b8","server":"65535","farm":66,"title":"Baby Amelia","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46864023755","owner":"163799850@N04","secret":"cf3dc2053b","server":"65535","farm":66,"title":"Bill","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991107514","owner":"34013737@N06","secret":"c17c30b2c4","server":"65535","farm":66,"title":"Hello Tiggy Cowsie Grady","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903261338","owner":"124105016@N02","secret":"a654ce570b","server":"65535","farm":66,"title":"20190505-_DSC1541","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780304621","owner":"61660161@N08","secret":"42bcdd5c4f","server":"65535","farm":66,"title":"IMG_6868","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780302371","owner":"142266470@N02","secret":"1c87a2386a","server":"65535","farm":66,"title":"137_Sicilia 2019","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991099404","owner":"34013737@N06","secret":"d434b22028","server":"65535","farm":66,"title":"3  Cute Kitts","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836806017","owner":"91701539@N03","secret":"daf6828794","server":"65535","farm":66,"title":"Sur la route de Kanab- Utah- Etats-Unis.","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903227848","owner":"66210868@N08","secret":"fac86c404f","server":"65535","farm":66,"title":"Summertime Sadness","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780290161","owner":"13186010@N00","secret":"21cc6a047a","server":"65535","farm":66,"title":"Canon A-1-2019-1-2","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46991078104","owner":"13186010@N00","secret":"aedbb352f2","server":"65535","farm":66,"title":"Canon A-1-2019-1-1","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780290241","owner":"165318893@N06","secret":"5b694646a0","server":"65535","farm":66,"title":"15 Simple Yet Stunning Hairstyle Tutorials for Lazy Women","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903182728","owner":"157726557@N03","secret":"7ef80e9379","server":"65535","farm":66,"title":"IMG_0686","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727883602","owner":"169881274@N05","secret":"2a81116cd4","server":"65535","farm":66,"title":"DSC03211","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813785293","owner":"169881274@N05","secret":"f110c437ed","server":"65535","farm":66,"title":"DSC03181","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903026908","owner":"169881274@N05","secret":"932b62c943","server":"65535","farm":66,"title":"DSC03182","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813784343","owner":"169881274@N05","secret":"496b0493a2","server":"65535","farm":66,"title":"DSC03183","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780246211","owner":"129323740@N08","secret":"ff9aa33ba3","server":"65535","farm":66,"title":"Kot","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813970733","owner":"164176290@N04","secret":"db53bbf955","server":"65535","farm":66,"title":"Ética animal, cultura de Paz y activismo académico; por Margarita Carretero González","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728068342","owner":"168565288@N03","secret":"d532f060bf","server":"65535","farm":66,"title":"Ética animal, cultura de Paz y activismo académico; por Margarita Carretero González","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728061732","owner":"100032311@N06","secret":"d6e2af80a7","server":"65535","farm":66,"title":"B&M No. 3713 THE CONSTITUTION (4-6-2) Class P-4-a enroute by car float from North Station to the Museum of Science, Boston and Cambridge, Mass., 1969","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728057772","owner":"107626825@N07","secret":"b548d29a74","server":"65535","farm":66,"title":"日本橋","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836740507","owner":"148057290@N06","secret":"913c5474bc","server":"65535","farm":66,"title":"DSC4900_DxO","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836727867","owner":"40680990@N08","secret":"7e3221225e","server":"65535","farm":66,"title":"Pepe","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836722207","owner":"165254451@N05","secret":"8ca16335e4","server":"65535","farm":66,"title":"_DSC9800","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863881195","owner":"94706054@N05","secret":"186bb312be","server":"65535","farm":66,"title":"Onion Bulb Boutique Faceup Collage","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813916263","owner":"151448152@N04","secret":"f6bf857762","server":"65535","farm":66,"title":"Literally 16","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813920973","owner":"152449808@N03","secret":"b9ec7c2ce2","server":"65535","farm":66,"title":"Merriweather_0462","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903155718","owner":"157579733@N07","secret":"0e491d7979","server":"65535","farm":66,"title":"Gecko cat?","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47728007572","owner":"169928236@N06","secret":"b9f1215f76","server":"65535","farm":66,"title":"This is a baby tiger I saw in Phuket, Thailand. Decided to change the original to black and white because I felt the quality and the lighting of this picture looked better.","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47780206521","owner":"151187872@N05","secret":"5ba9c9b7cd","server":"65535","farm":66,"title":"DSC08346","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836699857","owner":"146376068@N02","secret":"7eb1bc607a","server":"65535","farm":66,"title":"IMG_20190401_071035_192","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863852595","owner":"67089641@N05","secret":"52f302b293","server":"65535","farm":66,"title":"Jana","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863852555","owner":"67089641@N05","secret":"e46e32ba61","server":"65535","farm":66,"title":"Jana","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903146188","owner":"67089641@N05","secret":"b40ff2f855","server":"65535","farm":66,"title":"Jana","ispublic":1,"isfriend":0,"isfamily":0},{"id":"32836696147","owner":"44561865@N02","secret":"09130f9204","server":"65535","farm":66,"title":"DSCF5153.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990966254","owner":"44561865@N02","secret":"9eb43e7be5","server":"65535","farm":66,"title":"DSCF5092.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903139328","owner":"170999419@N03","secret":"247f5bf4f5","server":"65535","farm":66,"title":"How To Apply Foundation Like A Pro \u2013 Step By Step Guide","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990962404","owner":"151187872@N05","secret":"bcda7b8a60","server":"65535","farm":66,"title":"DSC08331","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863843845","owner":"151187872@N05","secret":"fa903c0df8","server":"65535","farm":66,"title":"DSC08337","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727988382","owner":"151187872@N05","secret":"fccba77b18","server":"65535","farm":66,"title":"DSC08340","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727988052","owner":"151187872@N05","secret":"042a51bbb1","server":"65535","farm":66,"title":"DSC08350","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987862","owner":"151187872@N05","secret":"ef192f996b","server":"65535","farm":66,"title":"DSC08356","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46863843505","owner":"151187872@N05","secret":"e30b4c6c6d","server":"65535","farm":66,"title":"DSC08355","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987712","owner":"151187872@N05","secret":"9119d58199","server":"65535","farm":66,"title":"DSC08360","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987782","owner":"151187872@N05","secret":"87767d3f5a","server":"65535","farm":66,"title":"DSC08359","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990961284","owner":"151187872@N05","secret":"77b6a97911","server":"65535","farm":66,"title":"DSC08357","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987532","owner":"151187872@N05","secret":"66ccbcbd4f","server":"65535","farm":66,"title":"DSC08371","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813898783","owner":"151187872@N05","secret":"d73e64130a","server":"65535","farm":66,"title":"DSC08374","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987582","owner":"151187872@N05","secret":"b7033887ab","server":"65535","farm":66,"title":"DSC08366","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813898633","owner":"151187872@N05","secret":"89191f7fce","server":"65535","farm":66,"title":"DSC08383","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727987462","owner":"151187872@N05","secret":"b8054403ae","server":"65535","farm":66,"title":"DSC08375","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990960454","owner":"151187872@N05","secret":"ec5f03e612","server":"65535","farm":66,"title":"DSC08387","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903137098","owner":"151187872@N05","secret":"4889cf7919","server":"65535","farm":66,"title":"DSC08402","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903136828","owner":"151187872@N05","secret":"3c15c8b019","server":"65535","farm":66,"title":"DSC08411","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990959704","owner":"151187872@N05","secret":"7586742ff7","server":"65535","farm":66,"title":"DSC08409","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986552","owner":"151187872@N05","secret":"1da9ab78d7","server":"65535","farm":66,"title":"DSC08412","ispublic":1,"isfriend":0,"isfamily":0},{"id":"33903136738","owner":"151187872@N05","secret":"770c058aa6","server":"65535","farm":66,"title":"DSC08416","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990959544","owner":"151187872@N05","secret":"f8bb73a2c1","server":"65535","farm":66,"title":"DSC08413","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986382","owner":"151187872@N05","secret":"483d0c6d92","server":"65535","farm":66,"title":"DSC08419","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986322","owner":"151187872@N05","secret":"bbea39feed","server":"65535","farm":66,"title":"DSC08421","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986272","owner":"151187872@N05","secret":"c8c0dd2be4","server":"65535","farm":66,"title":"DSC08426","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813897563","owner":"151187872@N05","secret":"2eab249d99","server":"65535","farm":66,"title":"DSC08333","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813897673","owner":"151187872@N05","secret":"5c2b758954","server":"65535","farm":66,"title":"DSC08422","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986142","owner":"151187872@N05","secret":"3554b8e0f9","server":"65535","farm":66,"title":"DSC08347","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727986082","owner":"151187872@N05","secret":"b97e9716ff","server":"65535","farm":66,"title":"DSC08358","ispublic":1,"isfriend":0,"isfamily":0},{"id":"46990958554","owner":"151187872@N05","secret":"9286acb0a2","server":"65535","farm":66,"title":"DSC08384","ispublic":1,"isfriend":0,"isfamily":0},{"id":"47727985942","owner":"151187872@N05","secret":"ac5250345d","server":"65535","farm":66,"title":"DSC08376","ispublic":1,"isfriend":0,"isfamily":0},{"id":"40813896413","owner":"8426916@N04","secret":"9ea1a32a4d","server":"65535","farm":66,"title":"Beachwood Lion","ispublic":1,"isfriend":0,"isfamily":0}]
         */

        private int page;
        private int pages;
        private int perpage;
        private String total;
        private ArrayList<PhotoBean> photo;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPerpage() {
            return perpage;
        }

        public void setPerpage(int perpage) {
            this.perpage = perpage;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public ArrayList<PhotoBean> getPhoto() {
            return photo;
        }

        public void setPhoto(ArrayList<PhotoBean> photo) {
            this.photo = photo;
        }

        public static class PhotoBean implements Parcelable {
            /**
             * id : 46864121115
             * owner : 147047514@N05
             * secret : 7823f07371
             * server : 65535
             * farm : 66
             * title : panda
             * ispublic : 1
             * isfriend : 0
             * isfamily : 0
             */

            private String id;
            private String owner;
            private String secret;
            private String server;
            private int farm;
            private String title;
            private int ispublic;
            private int isfriend;
            private int isfamily;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOwner() {
                return owner;
            }

            public void setOwner(String owner) {
                this.owner = owner;
            }

            public String getSecret() {
                return secret;
            }

            public void setSecret(String secret) {
                this.secret = secret;
            }

            public String getServer() {
                return server;
            }

            public void setServer(String server) {
                this.server = server;
            }

            public int getFarm() {
                return farm;
            }

            public void setFarm(int farm) {
                this.farm = farm;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getIspublic() {
                return ispublic;
            }

            public void setIspublic(int ispublic) {
                this.ispublic = ispublic;
            }

            public int getIsfriend() {
                return isfriend;
            }

            public void setIsfriend(int isfriend) {
                this.isfriend = isfriend;
            }

            public int getIsfamily() {
                return isfamily;
            }

            public void setIsfamily(int isfamily) {
                this.isfamily = isfamily;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.owner);
                dest.writeString(this.secret);
                dest.writeString(this.server);
                dest.writeInt(this.farm);
                dest.writeString(this.title);
                dest.writeInt(this.ispublic);
                dest.writeInt(this.isfriend);
                dest.writeInt(this.isfamily);
            }

            public PhotoBean() {
            }

            protected PhotoBean(Parcel in) {
                this.id = in.readString();
                this.owner = in.readString();
                this.secret = in.readString();
                this.server = in.readString();
                this.farm = in.readInt();
                this.title = in.readString();
                this.ispublic = in.readInt();
                this.isfriend = in.readInt();
                this.isfamily = in.readInt();
            }

            public static final Creator<PhotoBean> CREATOR = new Creator<PhotoBean>() {
                @Override
                public PhotoBean createFromParcel(Parcel source) {
                    return new PhotoBean(source);
                }

                @Override
                public PhotoBean[] newArray(int size) {
                    return new PhotoBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.page);
            dest.writeInt(this.pages);
            dest.writeInt(this.perpage);
            dest.writeString(this.total);
            dest.writeTypedList(this.photo);
        }

        public PhotosBean() {
        }

        protected PhotosBean(Parcel in) {
            this.page = in.readInt();
            this.pages = in.readInt();
            this.perpage = in.readInt();
            this.total = in.readString();
            this.photo = in.createTypedArrayList(PhotoBean.CREATOR);
        }

        public static final Creator<PhotosBean> CREATOR = new Creator<PhotosBean>() {
            @Override
            public PhotosBean createFromParcel(Parcel source) {
                return new PhotosBean(source);
            }

            @Override
            public PhotosBean[] newArray(int size) {
                return new PhotosBean[size];
            }
        };
    }
}
