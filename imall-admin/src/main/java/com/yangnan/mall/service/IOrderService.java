package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.pojo.query.OrderQuery;
import com.yangnan.mall.util.LayUITableJSONResult;

public interface IOrderService {

    Order selectById(Long id);

    LayUITableJSONResult selectByPage(OrderQuery orderQuery);

}
