package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/selectByName")
    public String selectByName(String name, Model model) {
        System.out.println("66");
        List<Product> list = productService.selectByName(name);
        model.addAttribute("list", list);
        return "product_list";
    }

    @RequestMapping("/getProductDetailPage")
    public String getProductDetailPage(Integer id, Model model) {
        Product product = productService.selectById(id);
        model.addAttribute("product", product);
        return "product_detail";
    }

    @RequestMapping("/getProductListPage")
    public String getProductListPage(Integer id, Model model) {
        List<Product> list = productService.selectByCategoryId(id);
        model.addAttribute("list", list);
        return "product_list";
    }
}