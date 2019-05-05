package com.donglei.myblog.controller;

import com.donglei.myblog.entity.Blog;
import com.donglei.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BlogController {

    String con;

    @Autowired
    BlogService blogService;

    @RequestMapping("/hello")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView("blog/simple");
        modelAndView.addObject("s","hello");
        return modelAndView;
    }

    @RequestMapping("/select")
    public String selectBlog(int id){
        String content = blogService.selectBlog(id).getContent();
//        System.out.println("content========"+content);
        return content;
    }

    @RequestMapping("/insert")
    public void insertBlog(String content){
        Blog blog = new Blog(content);
        blogService.insertBlog(blog);
        //return "success";
    }

    @RequestMapping("contentCommit")
    public ModelAndView contentCommit(String content){
        // 将content存到数据库
        insertBlog(content);

        ModelAndView modelAndView = new ModelAndView("blog/view");
        //将内容发送至前台预览
        //modelAndView.addObject("viewContent" , content);
        System.out.println("跳转至内容显示页面");
        return modelAndView;
    }

    @RequestMapping("getContent")
    @ResponseBody
    public String getContent(){
        int id = blogService.lastId();
        con = selectBlog(id);
        return con;
    }

//    @RequestMapping("/show")
//    @ResponseBody
//    public ModelAndView show(){
//        int id = blogService.lastId();
//        ModelAndView modelAndView = new ModelAndView("blog/view");
//        String content = selectBlog(id);
//        System.out.println(id);
//        modelAndView.addObject("viewContent" , content);
//        System.out.println("跳转至内容显示页面");
//        return modelAndView;
//    }

    @RequestMapping("/show")
    @ResponseBody
    public ModelAndView show(@RequestParam(value = "id", required = false,defaultValue = "0") int id){
        System.out.println(id);
        if(id == 0){
            System.out.println("HHHHHH");
            id = blogService.lastId();
        }

        ModelAndView modelAndView = new ModelAndView("blog/view");
        String content = selectBlog(id);
        System.out.println(content);
        modelAndView.addObject("viewContent" , content);
        System.out.println("跳转至内容显示页面");
        return modelAndView;
    }


}
