package com.yangnan.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/getProductListPage")
    public String getProductListPage() {
        return "product_list";
    }
}