package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.pojo.Shipping;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.vo.CartVO;
import com.yangnan.mall.pojo.vo.OrderVO;
import com.yangnan.mall.service.ICartService;
import com.yangnan.mall.service.IOrderService;
import com.yangnan.mall.service.IShippingService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IShippingService shippingService;
    @Autowired
    private ICartService cartService;
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/getOrderConfirmPage")
    public String getOrderConfirmPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Shipping> shippingList = shippingService.selectByUserId(user.getId());
        List<CartVO> cartVOList =  cartService.selectByUserIdAndChecked(user.getId());
        model.addAttribute("shippingList", shippingList);
        model.addAttribute("cartVOList", cartVOList);
        return "order_confirm";
    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONResult add(Order order, HttpSession session) {
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getId());
        return orderService.add(order);
    }

    @RequestMapping("/getOrderListPage")
    public String getOrderListPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<OrderVO> list = orderService.selectByUserId(user.getId());
        model.addAttribute("list", list);
        return "order_list";
    }
}
