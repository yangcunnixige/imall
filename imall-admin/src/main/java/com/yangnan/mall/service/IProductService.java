package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.pojo.query.ProductQuery;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;

import java.util.List;

public interface IProductService {
    Product selectById(Integer id);

    List<Product> selectAll();

    LayUITableJSONResult selectByPage(ProductQuery productQuery);

    JSONResult deleteById(Integer id);

    JSONResult deleteAll(Integer[] ids);

    JSONResult add(Product product);
}