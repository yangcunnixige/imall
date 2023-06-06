package com.yangnan.mall.mapper;

import com.yangnan.mall.pojo.OrderItem;
import com.yangnan.mall.pojo.query.OrderDetailQuery;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> selectDetailByPage(OrderDetailQuery orderDetaiQuery);
}