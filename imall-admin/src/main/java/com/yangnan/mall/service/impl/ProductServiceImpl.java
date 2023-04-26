package com.yangnan.mall.service.impl;

import com.yangnan.mall.mapper.ProductMapper;
import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.pojo.query.ProductQuery;
import com.yangnan.mall.service.IProductService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selectById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }

    @Override
    public LayUITableJSONResult selectByPage(ProductQuery productQuery) {
        PageHelper.startPage(productQuery.getPage(), productQuery.getLimit());
        List<Product> list = productMapper.selectByPage(productQuery);
        PageInfo pageInfo = new PageInfo(list);
        long totalCount = pageInfo.getTotal();

        return LayUITableJSONResult.ok((int)totalCount, list);
    }

    @Override
    public JSONResult deleteById(Integer id) {
        int count = productMapper.deleteByPrimaryKey(id);
        return count == 1 ? JSONResult.ok("删除成功") : JSONResult.error("删除失败");
    }
}