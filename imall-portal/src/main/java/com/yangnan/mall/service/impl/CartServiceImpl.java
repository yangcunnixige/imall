package com.yangnan.mall.service.impl;

import com.yangnan.mall.mapper.CartMapper;
import com.yangnan.mall.pojo.Cart;
import com.yangnan.mall.service.ICartService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public JSONResult add(Cart cart) {
        int count = cartMapper.insertSelective(cart);
        return count == 1 ? JSONResult.ok("插入成功") : JSONResult.error("插入失败");
    }
}