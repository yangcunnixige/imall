package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Category> topCategoryList = categoryService.selectTopCategoryList();
        List<Category> secondCategoryList = categoryService.selectSecondCategoryList();
        model.addAttribute("topCategoryList", topCategoryList);
        model.addAttribute("secondCategoryList", secondCategoryList);
        return "index";
    }
}