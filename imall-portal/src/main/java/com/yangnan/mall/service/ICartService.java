package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Cart;
import com.yangnan.mall.util.JSONResult;

public interface ICartService {
    JSONResult add(Cart cart);
}