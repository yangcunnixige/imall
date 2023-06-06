package com.yangnan.mall.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.yangnan.mall.mapper.CategoryMapper;
import com.yangnan.mall.service.ICategoryService;
import com.yangnan.mall.util.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/echarts")
public class EchartsController {

    @Autowired
    private ICategoryService categoryService;


    @RequestMapping("/getEchartsPage")
    public String getEchartsPage() {
        System.out.println("echarts.getEchartsPage");
        return "echarts";
    }

    @RequestMapping("/getEcharts")
    @ResponseBody
    public JSONResult getEcharts() {
        System.out.println("echarts.getEcharts");
        return categoryService.selectCategoryCount();
    }
}