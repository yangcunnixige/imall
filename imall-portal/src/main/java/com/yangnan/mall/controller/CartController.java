package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Cart;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.vo.CartVO;
import com.yangnan.mall.service.ICartService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String  getCartListPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<CartVO> list = cartService.selectByUserId(user.getId());
        model.addAttribute("list", list);
        return "cart_list";
    }

    @RequestMapping("/updateChecked")
    @ResponseBody
    public JSONResult updateChecked(Integer id, Integer checked) {
        return cartService.updateChecked(id, checked);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public JSONResult deleteById(Integer id) {
        return cartService.deleteById(id);
    }

    @RequestMapping("/updateQuantity")
    @ResponseBody
    public JSONResult updateQuantity(Integer id, Integer quantity) {
        return cartService.updateQuantity(id, quantity);
    }

    @RequestMapping("/updateCheckedAll")
    @ResponseBody
    public JSONResult updateCheckedAll(HttpSession session, Integer checked) {
        User user = (User) session.getAttribute("user");
        return cartService.updateCheckedAll(user.getId(), checked);
    }

}