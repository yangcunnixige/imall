package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Carousel;
import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.pojo.query.CarouselQuery;
import com.yangnan.mall.pojo.query.ProductQuery;
import com.yangnan.mall.service.ICarouselService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private ICarouselService carouselService;

    @RequestMapping("/getCarouselListPage")
    public String getCarouselListPage() {
        return "carousel_list";
    }

    @RequestMapping("/selectByPage")
    @ResponseBody
    public LayUITableJSONResult selectByPage(CarouselQuery carouselQuery) {
        System.out.println("CarouselController.selectByPage");
        return carouselService.selectByPage(carouselQuery);
    }

    @RequestMapping("/getCarouselAddPage")
    public String getProductAddPage() {
        return "carousel_add";
    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONResult add(Carousel carousel) {
        System.out.println("CarouselController.add");
        return carouselService.add(carousel);
    }

    @RequestMapping("/getCarouselUpdatePage")
    public String getCarouselUpdatePage(Integer id, Model model) {
        Carousel carousel = carouselService.selectById(id);
        model.addAttribute("carousel", carousel);
        return "carousel_update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public JSONResult update(Carousel carousel) {
        System.out.println("CarouselController.update");
        return carouselService.update(carousel);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public JSONResult deleteById(Integer id) {
        System.out.println("CarouselController.deleteById");
        return carouselService.deleteById(id);
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public JSONResult deleteAll(Integer[] ids) {
        System.out.println("CarouselController.deleteAll");
        return carouselService.deleteAll(ids);
    }
}