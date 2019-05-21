package com.donglei.myblog.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.*;


@SpringBootConfiguration
public class AdminLoginAdapter implements WebMvcConfigurer {

//    WebMvcConfigurationSupport

    @Autowired
    AdminLoginInterceptor adminLoginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/admin").excludePathPatterns("/login/**");
        //registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/index");
        //super.addInterceptors(registry);
    }





}
