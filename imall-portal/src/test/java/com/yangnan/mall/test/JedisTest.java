package com.yangnan.mall.test;

import com.sun.javaws.jnl.JARDesc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

public class JedisTest {

    @Test
    public void test1() {
        //1.连接Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //2.操作Redis
        jedis.set("name", "java");
        String name = jedis.get("name");
        System.out.println(name);
        //3.关闭Redis
        jedis.close();
    }
}