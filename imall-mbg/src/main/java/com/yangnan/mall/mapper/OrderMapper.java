package com.yangnan.mall.mapper;

import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.pojo.OrderItem;
import com.yangnan.mall.pojo.query.OrderDetailQuery;
import com.yangnan.mall.pojo.query.OrderQuery;
import com.yangnan.mall.pojo.vo.OrderVO;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderVO> selectByUserId(Integer id);

    List<Order> selectByPage(OrderQuery orderQuery);

    int deleteAll(Long[] ids);
}