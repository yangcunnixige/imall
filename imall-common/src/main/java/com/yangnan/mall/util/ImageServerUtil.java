package com.yangnan.mall.util;

/**
 * 切换图片上传服务器：QINIU、LOCAL
 */
public class ImageServerUtil {
    public static final int QINIU = 0;
    public static final int LOCAL = 1;

    public static final int IMAGE_SERVER = LOCAL;

    public static final String IMAGE_SERVER_LOCAL = "/pic/";
    public static final String IMAGE_SERVER_QINIU = "http://rtrkl7rcm.hd-bkt.clouddn.com/";

    public static String getImageUrl(String fileName) {
        if (IMAGE_SERVER == LOCAL) {
            return IMAGE_SERVER_LOCAL + fileName;
        } else {
            return IMAGE_SERVER_QINIU + fileName;
        }
    }
}