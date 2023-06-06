package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Carousel;
import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.service.ICarouselService;
import com.yangnan.mall.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ICarouselService carouselService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/")
    public String index(Model model) {
        List<Category> topCategoryList = redisTemplate.opsForList().range("topCategoryList", 0, -1);
        if (CollectionUtils.isEmpty(topCategoryList)) {//缓存里面没有
            topCategoryList = categoryService.selectTopCategoryList();
            //把数据更新到缓存里面
            redisTemplate.opsForList().rightPushAll("topCategoryList", topCategoryList);
        }
        List<Category> secondCategoryList = categoryService.selectSecondCategoryList();
        model.addAttribute("topCategoryList", topCategoryList);
        model.addAttribute("secondCategoryList", secondCategoryList);

        List<Carousel> carouselList = carouselService.selectAll();
        System.out.println(carouselList);
        model.addAttribute("carouselList",carouselList);
        return "index";
    }
}