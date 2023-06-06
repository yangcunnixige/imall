package com.yangnan.mall.mapper;

import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.pojo.vo.CategoryCountVO;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectTopCategoryList();

    List<Category> selectSecondCategoryListByTopCategoryId(Integer id);

    List<Category> selectSecondCategoryList();

    int selectTopCategoryIdBySecondCategotyId(Integer id);

    List<CategoryCountVO> selectCategoryCount();
}