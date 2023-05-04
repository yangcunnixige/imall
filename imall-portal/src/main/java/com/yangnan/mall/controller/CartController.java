package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Cart;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.service.ICartService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @RequestMapping("/add")
    @ResponseBody
    public JSONResult add(Cart cart, HttpSession session) {
        User user = (User) session.getAttribute("user");
        cart.setUserId(user.getId());
        return cartService.add(cart);
    }

    @RequestMapping("/getCartListPage")
    public String  getCartListPage() {
        return "cart_list";
    }
}