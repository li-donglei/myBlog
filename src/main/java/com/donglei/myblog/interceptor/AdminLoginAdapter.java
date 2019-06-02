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
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/login/**");
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/blogedit").excludePathPatterns("/login/**");
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/adminBlog").excludePathPatterns("/login/**");

        //super.addInterceptors(registry);
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/desktop/**").addResourceLocations("file:C:/users/18451/desktop/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:C:/Users/18451/Desktop/upload/");
        //registry.addResourceHandler("/upload/**").addResourceLocations("file:/usr/develop/upload");


    }

}
