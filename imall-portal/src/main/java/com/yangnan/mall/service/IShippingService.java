package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Shipping;
import com.yangnan.mall.util.JSONResult;

import java.util.List;

public interface IShippingService {

    List<Shipping> selectByUserId(Integer id);

    JSONResult addShipping(Shipping shipping);

    JSONResult deleteById(Integer id);
}
