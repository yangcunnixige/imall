package com.yangnan.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan("com.yangnan.mall.mapper")
public class PortalApplication {
    private static final Logger LOG = LoggerFactory.getLogger(PortalApplication.class);

    public static void main(String[] args) {
        //SpringApplication.run(AdminApplication.class, args);

        SpringApplication app = new SpringApplication(PortalApplication.class);
        Environment environment = app.run(args).getEnvironment();
        LOG.info("启动成功");
        LOG.info("地址:\thttp://localhost:{}", environment.getProperty("server.port"));
    }
}