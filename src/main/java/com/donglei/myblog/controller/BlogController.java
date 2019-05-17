package com.donglei.myblog.controller;

import com.donglei.myblog.entity.Blog;
import com.donglei.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;


@RestController
public class BlogController {

    String con;

    @Autowired
    BlogService blogService;

    @RequestMapping("/blogedit")
    public ModelAndView blogedit(){
        ModelAndView modelAndView = new ModelAndView("blog/simple");
        //modelAndView.addObject("s","hello");
        return modelAndView;
    }

    @RequestMapping("/select")
    public String selectBlog(int id){
        String content = blogService.selectBlog(id).getContent();
//        System.out.println("content========"+content);
        return content;
    }

//    @RequestMapping("getIndex")
//    public Map<String,String> getIndex(Map<String,String> map){
//        return map;
//    }

    @RequestMapping("/insert")
    public void insertBlog(String title, String summary, String content,String createtime,String catalog){
        Blog blog = new Blog(title,summary,content,createtime,catalog);
        blogService.insertBlog(blog);
        //return "success";
    }

    @RequestMapping("contentCommit")
    public ModelAndView contentCommit(@ModelAttribute Blog blog){
        // 获取title
        //String title = request.getParameter("title");
        String title = blog.getTitle();
        String content = blog.getContent();
        String summary = blog.getSummary();
        String createtime = new Date().toLocaleString();
        String catalog = blog.getCatalog();
//        System.out.println(title);
//        System.out.println(createtime);
        //String content = request.getParameter("content");
        // 将content存到数据库

        insertBlog(title,summary,content,createtime,catalog);

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

    /**
     * 展示响应博客页面
     * @param id
     * @return
     */
    @RequestMapping("/show")
    @ResponseBody
    public ModelAndView show(@RequestParam(value = "id", required = false,defaultValue = "0") int id){
        System.out.println(id);
        if(id == 0){
            id = blogService.lastId();
        }

        ModelAndView modelAndView = new ModelAndView("blog/blogview");
        String content = selectBlog(id);
        //System.out.println(content);
        modelAndView.addObject("viewContent" , content);
        System.out.println("跳转至内容显示页面");
        return modelAndView;
    }



}
