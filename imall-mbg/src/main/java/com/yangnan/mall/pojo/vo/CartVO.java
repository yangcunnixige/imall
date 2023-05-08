package com.yangnan.mall.pojo.vo;

import com.yangnan.mall.util.ImageServerUtil;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartVO {
    private Integer id;
    private Integer checked;
    private Integer quantity;
    private Integer productId;
    private String productMainImage;
    private String productName;
    private BigDecimal productPrice;

    public String getMainImageFullUrl() {
        return ImageServerUtil.getImageUrl(productMainImage);
    }
}