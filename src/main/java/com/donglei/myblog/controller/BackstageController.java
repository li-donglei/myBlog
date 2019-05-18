package com.donglei.myblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BackstageController {

    @RequestMapping("/backstage")
    public ModelAndView backstage(ModelAndView modelAndView){

        modelAndView.setViewName("backstage/backstage");
        return modelAndView;

    }
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){

//        modelAndView.setViewName("blog/backstage");
        modelAndView.setViewName("backstage/login");
        return modelAndView;

    }
    @RequestMapping("/loginInfo")
    public ModelAndView loginInfo(ModelAndView modelAndView){


//        modelAndView.setViewName("blog/backstage");
        modelAndView.setViewName("backstage/login");
        return modelAndView;

    }

}
