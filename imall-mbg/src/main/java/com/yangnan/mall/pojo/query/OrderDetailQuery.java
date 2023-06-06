package com.yangnan.mall.pojo.query;

import lombok.Data;

@Data
public class OrderDetailQuery {
    private Integer page;
    private Integer limit;
    private Long orderNo;
}
