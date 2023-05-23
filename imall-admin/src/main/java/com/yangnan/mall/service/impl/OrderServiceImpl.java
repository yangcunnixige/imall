package com.yangnan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangnan.mall.mapper.OrderMapper;
import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.query.OrderQuery;
import com.yangnan.mall.service.IOrderService;
import com.yangnan.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order selectById(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public LayUITableJSONResult selectByPage(OrderQuery orderQuery) {
        PageHelper.startPage(orderQuery.getPage(), orderQuery.getLimit());
        List<Order> list = orderMapper.selectByPage(orderQuery);
        PageInfo pageInfo = new PageInfo(list);
        long totalCount = pageInfo.getTotal();

        return LayUITableJSONResult.ok((int)totalCount, list);
    }
}
