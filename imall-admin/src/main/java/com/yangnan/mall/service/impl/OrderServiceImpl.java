package com.yangnan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangnan.mall.mapper.OrderItemMapper;
import com.yangnan.mall.mapper.OrderMapper;
import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.pojo.OrderItem;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.query.OrderDetailQuery;
import com.yangnan.mall.pojo.query.OrderQuery;
import com.yangnan.mall.service.IOrderService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import com.yangnan.mall.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

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

    @Override
    public JSONResult add(Order order) {
        SnowFlake snowFlake = new SnowFlake(1, 1);
        order.setOrderNo(snowFlake.nextId());
        int count = orderMapper.insertSelective(order);
        return count == 1 ? JSONResult.ok("添加成功") : JSONResult.error("添加失败");
    }

    @Override
    public JSONResult update(Order order) {
        int count = orderMapper.updateByPrimaryKeySelective(order);

        return count == 1 ? JSONResult.ok("更新成功") : JSONResult.error("更新失败");
    }

    @Override
    public JSONResult deleteById(Long id) {
        int count = orderMapper.deleteByPrimaryKey(id);
        return count == 1 ? JSONResult.ok("删除成功") : JSONResult.error("删除失败");
    }

    @Override
    public JSONResult deleteAll(Long[] ids) {
        int count = orderMapper.deleteAll(ids);
        return count == ids.length ? JSONResult.ok("删除成功") : JSONResult.error("删除失败");
    }

    @Override
    public LayUITableJSONResult selectDetailByPage(OrderDetailQuery orderDetailQuery) {
        PageHelper.startPage(orderDetailQuery.getPage(), orderDetailQuery.getLimit());
        List<OrderItem> list = orderItemMapper.selectDetailByPage(orderDetailQuery);
        PageInfo pageInfo = new PageInfo(list);
        long totalCount = pageInfo.getTotal();

        return LayUITableJSONResult.ok((int)totalCount, list);
    }
}
