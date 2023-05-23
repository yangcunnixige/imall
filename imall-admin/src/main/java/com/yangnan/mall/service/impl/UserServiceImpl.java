package com.yangnan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangnan.mall.mapper.UserMapper;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.query.UserQuery;
import com.yangnan.mall.service.IUserService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public LayUITableJSONResult selectByPage(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPage(), userQuery.getLimit());
        List<User> list = userMapper.selectByPage(userQuery);
        PageInfo pageInfo = new PageInfo(list);
        long totalCount = pageInfo.getTotal();

        return LayUITableJSONResult.ok((int)totalCount, list);
    }

    @Override
    public JSONResult add(User user) {
        int count = userMapper.insertSelective(user);
        return count == 1 ? JSONResult.ok("添加成功") : JSONResult.error("添加失败");
    }

    @Override
    public JSONResult update(User user) {
        int count = userMapper.updateByPrimaryKeySelective(user);

        return count == 1 ? JSONResult.ok("更新成功") : JSONResult.error("更新失败");
    }

    @Override
    public JSONResult deleteById(Integer id) {
        int count = userMapper.deleteByPrimaryKey(id);
        return count == 1 ? JSONResult.ok("删除成功") : JSONResult.error("删除失败");
    }

    @Override
    public JSONResult deleteAll(Integer[] ids) {
        int count = userMapper.deleteAll(ids);
        return count == ids.length ? JSONResult.ok("删除成功") : JSONResult.error("删除失败");
    }

    @Override
    public User login(String name, String password) {
        return userMapper.login(name, password);
    }
}
