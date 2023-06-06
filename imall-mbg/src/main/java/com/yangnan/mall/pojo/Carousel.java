package com.yangnan.mall.pojo;

import com.yangnan.mall.util.ImageServerUtil;
import lombok.Data;

import java.util.Date;

@Data
public class Carousel {
    private Integer id;
    private String imageUrl;
    private String linkUrl;
    private Integer sort;
    private Date createTime;
    private Date updateTime;
    private String mainImageFullUrl;
    public String getMainImageFullUrl() {
        return ImageServerUtil.getImageUrl(imageUrl);
    }

    // 省略getter和setter方法
}