package com.yangnan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangnan.mall.mapper.CarouselMapper;
import com.yangnan.mall.pojo.Carousel;
import com.yangnan.mall.pojo.query.CarouselQuery;
import com.yangnan.mall.service.ICarouselService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements ICarouselService{

    @Autowired
    private CarouselMapper carouselMapper;


    @Override
    public List<Carousel> selectAll() {
        return carouselMapper.selectAll();
    }

}