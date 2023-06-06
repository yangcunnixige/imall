package com.yangnan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangnan.mall.config.RedisConstant;
import com.yangnan.mall.mapper.CarouselMapper;
import com.yangnan.mall.pojo.Carousel;
import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.pojo.query.CarouselQuery;
import com.yangnan.mall.pojo.query.ProductQuery;
import com.yangnan.mall.service.ICarouselService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.SpanIterator;

import java.util.List;

@Service
public class CarouselServiceImpl implements ICarouselService{
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public LayUITableJSONResult selectByPage(CarouselQuery carouselQuery) {
        PageHelper.startPage(carouselQuery.getPage(), carouselQuery.getLimit());
        List<Carousel> list = carouselMapper.selectByPage(carouselQuery);
        PageInfo pageInfo = new PageInfo(list);
        long totalCount = pageInfo.getTotal();

        return LayUITableJSONResult.ok((int)totalCount, list);
    }

    @Override
    public JSONResult add(Carousel carousel) {
        System.out.println("123");
        System.out.println(carousel);
        int count = carouselMapper.insertSelective(carousel);
        System.out.println("321");
        //将上传的图片而且保存到数据库中保存到Redis里面
        redisTemplate.opsForSet().add(RedisConstant.UPLOAD_IMAGE_TO_DB, carousel.getImageUrl());

        return count == 1 ? JSONResult.ok("添加成功") : JSONResult.error("添加失败");
    }

    @Override
    public Carousel selectById(Integer id) {
        return carouselMapper.selectByPrimaryKey(id);
    }

    @Override
    public JSONResult update(Carousel carousel) {
        int count = carouselMapper.updateByPrimaryKeySelective(carousel);

        return count == 1 ? JSONResult.ok("更新成功") : JSONResult.error("更新失败");
    }

    @Override
    public JSONResult deleteById(Integer id) {
        int count = carouselMapper.deleteByPrimaryKey(id);
        return count == 1 ? JSONResult.ok("删除成功") : JSONResult.error("删除失败");
    }

    @Override
    public JSONResult deleteAll(Integer[] ids) {
        int count = carouselMapper.deleteAll(ids);
        return count == ids.length ? JSONResult.ok("删除成功") : JSONResult.error("删除失败");
    }

}