package com.yangnan.mall.quartz;

import com.yangnan.mall.config.RedisConstant;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.util.QiniuUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

@Configuration
public class DeleteImageJob {
    @Autowired
    private RedisTemplate redisTemplate;

    // <bean name="user" class="">
    @Bean
    public User createUser() {
        return new User();
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void deleteImage() {
        //System.out.println("DeleteImageJob.deleteImage");
        // 根据Redis中保存的两个Set集合做差值计算，获得上传但是没有使用的图片的集合
        Set<String> set = redisTemplate.opsForSet().difference(RedisConstant.UPLOAD_IMAGE, RedisConstant.UPLOAD_IMAGE_TO_DB);
        if (set != null) {
            for (String imageName : set) {
                //删除七牛云服务器上没有用的图片
                QiniuUtils.deleteFileFromQiniu(imageName);
                //Redis里面保存的没有用图片也可以删除掉了
                redisTemplate.opsForSet().remove(RedisConstant.UPLOAD_IMAGE, imageName);
                System.out.println("删除图片：" + imageName);
            }
        }
    }
}