package com.yangnan.mall.service.impl;

import com.yangnan.mall.mapper.CategoryMapper;
import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.service.ICategoryService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> selectTopCategoryList() {
        return categoryMapper.selectTopCategoryList();
    }

    @Override
    public List<Category> selectSecondCategoryListByTopCategoryId(Integer id) {
        List<Category> list = categoryMapper.selectSecondCategoryListByTopCategoryId(id);
        return list;
    }

    @Override
    public int selectTopCategoryIdBySecondCategotyId(Integer id) {
        return categoryMapper.selectTopCategoryIdBySecondCategotyId(id);
    }
}