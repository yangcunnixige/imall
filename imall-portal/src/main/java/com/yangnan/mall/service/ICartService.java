package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Cart;
import com.yangnan.mall.pojo.vo.CartVO;
import com.yangnan.mall.util.JSONResult;

import java.util.List;

public interface ICartService {
    JSONResult add(Cart cart);

    List<CartVO> selectByUserId(Integer id);

    JSONResult updateChecked(Integer id, Integer checked);

    JSONResult deleteById(Integer id);

    JSONResult updateQuantity(Integer id, Integer quantity);

    JSONResult updateCheckedAll(Integer userId, Integer checked);
}