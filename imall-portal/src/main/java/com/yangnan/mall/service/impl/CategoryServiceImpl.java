package com.yangnan.mall.service.impl;

import com.yangnan.mall.mapper.CategoryMapper;
import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Category> selectSecondCategoryList() {
        return categoryMapper.selectSecondCategoryList();
    }
}