package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.util.JSONResult;

public interface IOrderService {

    JSONResult add(Order order);
}