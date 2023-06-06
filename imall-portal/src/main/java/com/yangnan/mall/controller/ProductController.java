package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/selectByName")
    public String selectByName(String name, Model model) {
        System.out.println("66");
        List<Product> list = productService.selectByName(name);
        model.addAttribute("list", list);
        return "product_list";
    }

    @RequestMapping("/getProductDetailPage")
    public String getProductDetailPage(Integer id, Model model) {
        System.out.println("ProductController.getProductDetailPage");
        Product product = (Product) redisTemplate.opsForValue().get("product:" + id);
        if (product == null) {//redis缓存中没有
            System.out.println("product:" + id + "在缓存中没有，查找数据库");
            product = productService.selectById(id);
            if (product == null) {//数据库中没有
                redisTemplate.opsForValue().set("product:" + id, new Product(), 1, TimeUnit.MINUTES);
                product = new Product();
            } else {
                redisTemplate.opsForValue().set("product:" + id, product);
            }
        }
        System.out.println("1234   "+product.getMainImageFullUrl());
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