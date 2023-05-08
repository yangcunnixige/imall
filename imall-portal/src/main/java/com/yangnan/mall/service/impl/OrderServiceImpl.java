package com.yangnan.mall.service.impl;

import com.yangnan.mall.mapper.CartMapper;
import com.yangnan.mall.mapper.OrderItemMapper;
import com.yangnan.mall.mapper.OrderMapper;
import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.pojo.OrderItem;
import com.yangnan.mall.pojo.vo.CartVO;
import com.yangnan.mall.service.ICartService;
import com.yangnan.mall.service.IOrderService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private SnowFlake snowFlake;

    @Transactional
    @Override
    public JSONResult add(Order order) {
        //现在这个order对象里面已经有的是：shippingId、paymentType、userId
        //使用雪花算法生成订单Order订单主键
        long id = snowFlake.nextId();
        order.setOrderNo(id);

        //整个订单总金额
        BigDecimal payment = BigDecimal.valueOf(0.0);
        //购物车里面选中的要去结算的商品
        List<CartVO> cartVOList =  cartMapper.selectByUserIdAndChecked(order.getUserId());
        for (CartVO cartVO : cartVOList) {
            OrderItem orderItem = new OrderItem();
            //设置OrderItem是属于哪个订单下面的
            orderItem.setOrderNo(id);
            orderItem.setUserId(order.getUserId());
            orderItem.setProductId(cartVO.getProductId());
            orderItem.setProductName(cartVO.getProductName());
            orderItem.setProductImage(cartVO.getProductMainImage());
            orderItem.setCurrentUnitPrice(cartVO.getProductPrice());
            orderItem.setQuantity(cartVO.getQuantity());
            //totalPrice=商品价格*数量
            BigDecimal productPrice = cartVO.getProductPrice();
            BigDecimal quantity = BigDecimal.valueOf(cartVO.getQuantity());
            BigDecimal totalPrice = productPrice.multiply(quantity);
            orderItem.setTotalPrice(totalPrice);

            orderItemMapper.insertSelective(orderItem);

            payment = payment.add(totalPrice);
        }

        order.setPayment(payment);
        orderMapper.insertSelective(order);


        return JSONResult.ok("插入成功");
    }

    public static void main(String[] args) {
        System.out.println(0.1 + 0.2);//0.30000000000000004
    }
}