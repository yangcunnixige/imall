package com.yangnan.mall.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class TestValue {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void setValue(){
        redisTemplate.opsForValue().set("name", "gao1");
    }

    @Test
    public void getValue(){
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void deleteValue(){
        redisTemplate.delete("name");;
    }
}