package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Carousel;
import com.yangnan.mall.pojo.query.CarouselQuery;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;

import java.util.List;

public interface ICarouselService {

    List<Carousel> selectAll();
}
