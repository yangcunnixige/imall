package com.yangnan.mall.service;

import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.query.UserQuery;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;

public interface IUserService {
     User selectById(Integer id);

     LayUITableJSONResult selectByPage(UserQuery userQuery);

     JSONResult add(User user);

     JSONResult update(User user);

     JSONResult deleteById(Integer id);

     JSONResult deleteAll(Integer[] ids);
}
