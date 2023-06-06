package com.yangnan.mall.service.impl;

import com.yangnan.mall.mapper.ShippingMapper;
import com.yangnan.mall.pojo.Shipping;
import com.yangnan.mall.service.IShippingService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServiceImpl implements IShippingService {
    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public List<Shipping> selectByUserId(Integer id) {
        return shippingMapper.selectByUserId(id);
    }

    @Override
    public JSONResult addShipping(Shipping shipping) {
        int count = shippingMapper.insertSelective(shipping);
        return count == 1 ? JSONResult.ok("添加成功") : JSONResult.error("添加失败");
    }

    @Override
    public JSONResult deleteById(Integer id) {
        int count = shippingMapper.deleteByPrimaryKey(id);
        return count == 1 ? JSONResult.ok("删除成功") : JSONResult.error("删除失败");
    }
}
