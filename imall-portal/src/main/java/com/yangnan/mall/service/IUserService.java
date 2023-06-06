package com.yangnan.mall.service;

import com.yangnan.mall.pojo.User;
import com.yangnan.mall.util.JSONResult;

public interface IUserService {
    User login(String username, String password);

   int regist(User user);
}