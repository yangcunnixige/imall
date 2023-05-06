package com.yangnan.mall.service.impl;

import com.yangnan.mall.mapper.CartMapper;
import com.yangnan.mall.pojo.Cart;
import com.yangnan.mall.pojo.vo.CartVO;
import com.yangnan.mall.service.ICartService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public JSONResult add(Cart cart) {
        int cartCount = cartMapper.selectCountByUserIdAndProductId(cart);
        int count = 0;
        if (cartCount == 1) {//这个商品已经在这个用户的购物车里面，只要更新数量就可以
            count = cartMapper.updateCount(cart);
        } else {//这个商品没有在这个用户的购物车里面，直接插入购物车
            count = cartMapper.insertSelective(cart);
        }
        return count == 1 ? JSONResult.ok("插入成功") : JSONResult.error("插入失败");
    }

    @Override
    public List<CartVO> selectByUserId(Integer id) {
        return cartMapper.selectByUserId(id);
    }

    @Override
    public JSONResult updateChecked(Integer id, Integer checked) {
        int count = cartMapper.updateChecked(id, checked);
        return count == 1 ? JSONResult.ok("更新成功") : JSONResult.error("更新失败");
    }

    @Override
    public JSONResult deleteById(Integer id) {
        int count = cartMapper.deleteByPrimaryKey(id);
        return count == 1 ? JSONResult.ok("删除成功") : JSONResult.error("删除失败");
    }

    @Override
    public JSONResult updateQuantity(Integer id, Integer quantity) {
        int count = cartMapper.updateQuantity(id, quantity);
        return count == 1 ? JSONResult.ok("更新成功") : JSONResult.error("更新失败");
    }

    @Override
    public JSONResult updateCheckedAll(Integer userId, Integer checked) {
        int count = cartMapper.updateCheckedAll(userId, checked);
        return count >= 1 ? JSONResult.ok("更新成功") : JSONResult.error("更新失败");
    }
}