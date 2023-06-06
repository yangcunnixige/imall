package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.query.OrderDetailQuery;
import com.yangnan.mall.pojo.query.OrderQuery;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;

public interface IOrderService {

    Order selectById(Long id);

    LayUITableJSONResult selectByPage(OrderQuery orderQuery);

    JSONResult add(Order order);

    JSONResult update(Order order);

    JSONResult deleteById(Long id);

    JSONResult deleteAll(Long[] ids);

    LayUITableJSONResult selectDetailByPage(OrderDetailQuery orderDetailQuery);
}
