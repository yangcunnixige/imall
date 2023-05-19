package com.yangnan.mall.mapper;

import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.query.UserQuery;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String username, String password);

    List<User> selectByPage(UserQuery userQuery);

    int deleteAll(Integer[] ids);
}