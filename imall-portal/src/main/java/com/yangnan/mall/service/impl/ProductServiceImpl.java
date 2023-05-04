package com.yangnan.mall.service.impl;

import com.yangnan.mall.mapper.ProductMapper;
import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> selectByName(String name) {
        return productMapper.selectByName(name);
    }

    @Override
    public Product selectById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> selectByCategoryId(Integer id) {
        return productMapper.selectByCategoryId(id);
    }
}