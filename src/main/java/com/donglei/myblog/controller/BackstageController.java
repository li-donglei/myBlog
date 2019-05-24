package com.donglei.myblog.controller;

import com.donglei.myblog.entity.Blog;
import com.donglei.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@RestController
public class BackstageController {

    @Autowired
    BlogService blogService;


    @RequestMapping("/admin")
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
    public ModelAndView loginInfo(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        System.out.println(name);
        HttpSession session = request.getSession();
//        Cookie cookie = new Cookie("age",age);
//        response.addCookie(cookie);
        session.setAttribute("name",name);
        session.setAttribute("passwd",passwd);

        System.out.println("session.getAttribute(name)"+session.getAttribute("name"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @RequestMapping("/adminBlog")
    public ModelAndView adminBlog(ModelAndView modelAndView){
        List<Blog> blog= blogService.selectBlog();
        Collections.reverse(blog);//blog逆序
        modelAndView.addObject("blog",blog);
        modelAndView.setViewName("backstage/backstage");
        return modelAndView;

    }

}
