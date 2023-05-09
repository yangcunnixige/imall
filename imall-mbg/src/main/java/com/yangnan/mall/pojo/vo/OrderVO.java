package com.yangnan.mall.pojo.vo;

import com.yangnan.mall.pojo.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderVO {
    private Long orderNo;

    private BigDecimal payment;

    private Integer status;

    private Date gmtCreate;

    private List<OrderItem> list;

}