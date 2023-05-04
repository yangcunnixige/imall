package com.yangnan.mall.mapper;

import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.pojo.query.ProductQuery;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectAll();

    List<Product> selectByPage(ProductQuery productQuery);

    int deleteAll(Integer[] ids);

    List<Product> selectByName(String name);

    List<Product> selectByCategoryId(Integer id);
}