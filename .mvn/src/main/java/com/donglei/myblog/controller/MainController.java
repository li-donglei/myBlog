package com.donglei.myblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MainController {

    @Autowired
    BlogController blogController;
    @RequestMapping({"/","/index","/index.html"})
    public ModelAndView index(ModelAndView mv){
        mv.setViewName("index");
        mv.addObject("hello",blogController.getContent());
        return mv;
    }
}
