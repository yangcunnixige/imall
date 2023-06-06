package com.yangnan.mall.service;

import com.yangnan.mall.pojo.Carousel;
import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.pojo.query.CarouselQuery;
import com.yangnan.mall.pojo.query.ProductQuery;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICarouselService {

    JSONResult deleteById(Integer id);

    JSONResult deleteAll(Integer[] ids);

    LayUITableJSONResult selectByPage(CarouselQuery carouselQuery);

    JSONResult add(Carousel carousel);

    Carousel selectById(Integer id);

    JSONResult update(Carousel carousel);
}
