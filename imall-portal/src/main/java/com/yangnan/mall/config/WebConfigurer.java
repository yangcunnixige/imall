package com.yangnan.mall.config;

import org.springframework.context.annotation.Configuration;
import com.yangnan.mall.interceptor.LoginInterceptor;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    // 配置虚拟路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**")
                .addResourceLocations("file:/D:\\project\\blog\\src\\mypic\\");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求
        // excludePathPatterns()   代表排除哪些请求不需要拦截
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/cart/**", "/order/**","/user/getUserCenterPage","/user/getUserAddressPage");
    }
}