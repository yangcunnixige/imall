package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Shipping;

import java.util.List;

public interface IShippingService {
    List<Shipping> selectByUserId(Integer id);
}
