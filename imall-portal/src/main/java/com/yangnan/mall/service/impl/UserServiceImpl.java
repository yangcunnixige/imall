package com.yangnan.mall.service.impl;

import com.yangnan.mall.mapper.UserMapper;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.service.IUserService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public int regist(User user) {
        return userMapper.insertSelective(user);
    }
}