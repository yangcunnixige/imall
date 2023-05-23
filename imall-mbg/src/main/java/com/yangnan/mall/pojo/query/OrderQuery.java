package com.yangnan.mall.pojo.query;

import lombok.Data;

import java.util.Date;

@Data
public class OrderQuery {
    private Integer page;
    private Integer limit;
    private Long orderNo;
    private Integer userId;
    private Integer status;
    private Date beginGmtCreate;
    private Date endGmtCreate;
}