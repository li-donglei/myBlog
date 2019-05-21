package com.donglei.myblog.controller;


import com.donglei.myblog.entity.Blog;
import com.donglei.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@RestController
public class MainController {

    @Autowired
    BlogController blogController;
    @Autowired
    BlogService blogService;
    @RequestMapping({"/","/index","/index.html"})
    public ModelAndView index(ModelAndView mv){
        mv.setViewName("index");
        List<Blog> blog= blogService.selectBlog();
        Collections.reverse(blog);//blog逆序
        mv.addObject("blog",blog);
        return mv;
    }


}
