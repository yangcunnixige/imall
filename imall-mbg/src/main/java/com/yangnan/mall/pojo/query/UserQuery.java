package com.yangnan.mall.pojo.query;

import lombok.Data;

import java.util.Date;

@Data
public class UserQuery {
    private Integer page;
    private Integer limit;
    private String username;
    private Integer status;
    private Date beginGmtCreate;
    private Date endGmtCreate;
}