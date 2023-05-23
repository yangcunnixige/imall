package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.query.OrderQuery;
import com.yangnan.mall.service.IOrderService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public JSONResult deleteById(Long orderNo) {
        System.out.println("orderNo: " + orderNo);
        return JSONResult.ok("删除成功");
    }
}
