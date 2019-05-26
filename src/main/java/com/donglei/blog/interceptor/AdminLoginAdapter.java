package com.donglei.blog.interceptor;

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
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/blogedit").excludePathPatterns("/login/**");
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/adminBlog").excludePathPatterns("/login/**");
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/edit").excludePathPatterns("/login/**");


        //super.addInterceptors(registry);
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:C:/Users/18451/");
        //registry.addResourceHandler("/upload/**").addResourceLocations("file:C:/Users/18451/Desktop/upload/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:/usr/developer/apache-tomcat-8.5.37/webapps/ROOT/images");


    }

}
