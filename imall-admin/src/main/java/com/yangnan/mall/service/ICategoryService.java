package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.util.JSONResult;

import java.util.List;

public interface ICategoryService {
    List<Category> selectTopCategoryList();

    List<Category> selectSecondCategoryListByTopCategoryId(Integer id);

    int selectTopCategoryIdBySecondCategotyId(Integer id);
}