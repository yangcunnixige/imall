package com.yangnan.mall.mapper;

import com.yangnan.mall.pojo.Carousel;
import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.pojo.query.CarouselQuery;
import com.yangnan.mall.pojo.query.ProductQuery;

import java.util.List;

public interface CarouselMapper {

    int deleteById(Integer id);

    int update(Carousel carousel);

    Carousel getById(Integer id);

    List<Carousel> getAll();

    List<Carousel> selectByPage(CarouselQuery carouselQuery);

    int insertSelective(Carousel carousel);

    Carousel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Carousel record);

    int deleteByPrimaryKey(Integer id);

    int deleteAll(Integer[] ids);

    List<Carousel> selectAll();
}
