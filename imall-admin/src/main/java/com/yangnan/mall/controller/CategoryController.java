package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.service.ICategoryService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/selectSecondCategoryListByTopCategoryId")
    @ResponseBody
    public JSONResult selectSecondCategoryListByTopCategoryId(Integer id) {
        System.out.println("CategoryController.selectSecondCategoryListByTopCategoryId");
        List<Category> list = categoryService.selectSecondCategoryListByTopCategoryId(id);
        return JSONResult.ok(list);
    }
}