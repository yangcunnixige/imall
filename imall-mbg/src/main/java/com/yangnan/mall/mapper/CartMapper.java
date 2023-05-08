package com.yangnan.mall.mapper;

import com.yangnan.mall.pojo.Cart;
import com.yangnan.mall.pojo.vo.CartVO;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<CartVO> selectByUserId(Integer id);

    int selectCountByUserIdAndProductId(Cart cart);

    int updateCount(Cart cart);

    int updateChecked(Integer id, Integer checked);

    int updateQuantity(Integer id, Integer quantity);

    int updateCheckedAll(Integer userId, Integer checked);

    List<CartVO> selectByUserIdAndChecked(Integer id);
}