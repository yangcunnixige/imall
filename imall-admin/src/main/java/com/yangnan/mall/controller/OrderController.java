package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Order;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.query.OrderDetailQuery;
import com.yangnan.mall.pojo.query.OrderQuery;
import com.yangnan.mall.service.IOrderService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/getOrderListPage")
    public String getOrderListPage() {
        return "order_list";
    }

    @RequestMapping("/selectByPage")
    @ResponseBody
    public LayUITableJSONResult selectByPage(OrderQuery orderQuery) {
        System.out.println("OrderController.selectByPage");
        return orderService.selectByPage(orderQuery);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public JSONResult deleteById(Long id) {
        System.out.println("orderNo: " + id);
        return orderService.deleteById(id);
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public JSONResult deleteAll(Long[] ids) {
        System.out.println("UserController.deleteAll");
        return orderService.deleteAll(ids);
    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONResult add(Order order) {
        System.out.println("UserController.add");
        return orderService.add(order);
    }

    @RequestMapping("/getUserAddPage")
    public String getUserAddPage() {
        //List<Category> topCategoryList = categoryService.selectTopCategoryList();
        //model.addAttribute("topCategoryList", topCategoryList);
        return "order_add";
    }

    @RequestMapping("/getOrderUpdatePage")
    public String getOrderUpdatePage(Long id, Model model) {
        Order order = orderService.selectById(id);
        model.addAttribute("order", order);
        return "order_update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public JSONResult update(Order order) {
        System.out.println("OrderController.update");
        return orderService.update(order);
    }

    @RequestMapping("/getOrderDetailPage")
    public String getOrderDetailPage(Long id, HttpSession session) {
        Order order = orderService.selectById(id);
        session.setAttribute("order", order);
        return "order_detail";
    }

    @RequestMapping("/selectDetailByPage")
    @ResponseBody
    public LayUITableJSONResult selectDetailByPage(HttpSession session,OrderDetailQuery orderDetailQuery) {
        Order order = (Order)session.getAttribute("order");
        orderDetailQuery.setOrderNo(order.getOrderNo());
        System.out.println("OrderController.selectDetailByPage");
        return orderService.selectDetailByPage(orderDetailQuery);
    }

}
