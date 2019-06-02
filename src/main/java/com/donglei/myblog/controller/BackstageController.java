package com.donglei.myblog.controller;

import com.donglei.myblog.entity.Blog;
import com.donglei.myblog.service.BlogService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
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
    public ModelAndView loginInfo(HttpServletRequest request){
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
    public ModelAndView adminBlog(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                                  @RequestParam(value="pageSize",defaultValue="5")int pageSize,
                                  ModelAndView modelAndView){
        PageInfo<Blog> page= blogService.selectBlog(pageNo, pageSize);


        modelAndView.addObject("blog",page);
        modelAndView.setViewName("backstage/backstage");
        return modelAndView;

    }

    @RequestMapping("/admin/images")
    public ModelAndView imagesManagement(ModelAndView mv){

        File file = new File("c:/users/18451/desktop/upload");
        List<String> list = new ArrayList<>();

        File[] f1=file.listFiles();
        for (File file1 : f1){
            //System.out.println(file1.getName());
            list.add("/desktop/upload/"+file1.getName());
        }
        Collections.reverse(list);
        if(list.size()>6){
            list = list.subList(0,6);
        }
        mv.addObject("list",list);
        //mv.setViewName("backstage/imagesManagement");
        mv.setViewName("backstage/backstage");

        return mv;

    }

    @RequestMapping("/admin/deleteImage")
    public ModelAndView deleteImage(@RequestParam(value = "url")String url, ModelAndView modelAndView){
        //System.out.println("url====" + url);
        File file = new File("c:/users/18451"+url);
        if(file.isFile()&&file.exists()){
            file.delete();
        }else{}

        modelAndView.setViewName("redirect:/admin/images");
        return modelAndView;
    }


}
