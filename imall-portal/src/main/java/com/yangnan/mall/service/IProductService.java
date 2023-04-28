package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Product;

import java.util.List;

public interface IProductService {

    List<Product> selectByName(String name);

    Product selectById(Integer id);
}