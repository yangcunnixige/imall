package com.yangnan.mall.controller;

import com.yangnan.mall.config.RedisConstant;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.ImageServerUtil;
import com.yangnan.mall.util.QiniuUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/uploadImage")
    @ResponseBody
    public JSONResult uploadImage(MultipartFile file) {
        System.out.println("UploadController.uploadImage");
        //c44be503737d44f2b872c6e19160f43c
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String filename = file.getOriginalFilename();//a.png
        String extension = FilenameUtils.getExtension(filename);//png
        String newFileName = uuid + "." + extension;

        //上传到本地
        if (ImageServerUtil.IMAGE_SERVER == ImageServerUtil.LOCAL) {
            //c44be503737d44f2b872c6e19160f43c.png
            String filePath = "D:\\mypic\\" + newFileName;
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //上传到七牛云
            try {
                QiniuUtils.upload2Qiniu(file.getBytes(), newFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //将上传的图片保存到Redis里面
        redisTemplate.opsForSet().add(RedisConstant.UPLOAD_IMAGE, newFileName);

        return JSONResult.ok("", newFileName);
    }

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
    }
}