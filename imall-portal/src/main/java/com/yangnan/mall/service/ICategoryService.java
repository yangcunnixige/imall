package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> selectTopCategoryList();
    List<Category> selectSecondCategoryList();
}