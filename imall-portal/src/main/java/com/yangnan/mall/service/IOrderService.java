package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.pojo.vo.OrderVO;
import com.yangnan.mall.util.JSONResult;

import java.util.List;

public interface IOrderService {

    JSONResult add(Order order);

    List<OrderVO> selectByUserId(Integer id);
}