package com.donglei.myblog.controller;

import com.donglei.myblog.entity.Blog;
import com.donglei.myblog.service.BlogService;
import com.donglei.myblog.service.PVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.text.SimpleDateFormat;
import java.util.Date;



@RestController
public class BlogController {

    String con;

    @Autowired
    BlogService blogService;

    @Autowired
    PVService pvService;

    @RequestMapping("/blogedit")
    public ModelAndView blogedit(){



        ModelAndView modelAndView = new ModelAndView("blog/simple");
        //modelAndView.addObject("s","hello");
        return modelAndView;
    }

    @RequestMapping("/select")
    public String selectBlog(Long id){
        String content = blogService.selectBlog(id).getContent();
//        System.out.println("content========"+content);
        return content;
    }


    @RequestMapping("/insert")
    public void insertBlog(Long id, String title, String summary, String content, String createtime, Integer readsize, Integer commentsize, Integer votesize, String catalog){
        Blog blog = new Blog( id,  title,  summary,  content, createtime, readsize, commentsize, votesize,  catalog);
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
        // Date数据格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String createtime = sdf.format(new Date());

        String catalog = blog.getCatalog();

        // 将content存到数据库
        long id = new Date().getTime();
        Blog blog2 = new Blog( id,  title,  summary,  content, createtime, 0, 0, 0,  catalog);
        blogService.insertBlog(blog2);

        ModelAndView modelAndView = new ModelAndView("blog/view");
        //将内容发送至前台预览
        //modelAndView.addObject("viewContent" , content);
        //System.out.println("跳转至内容显示页面");
        return modelAndView;
    }

    @RequestMapping("getContent")
    @ResponseBody
    public String getContent(){
        Long id = blogService.lastId();
        con = selectBlog(id);
        return con;
    }

    /**
     * 展示响应博客页面
     * @param id
     * @return
     */
    @RequestMapping("/show")
    @ResponseBody
    public ModelAndView show(@RequestParam(value = "id", required = false,defaultValue = "0") Long id){

        // 更新PV访问量
        pvService.updatePV();
        //System.out.println(id);
        if(id == 0){
            id = blogService.lastId();
        }
        blogService.updateReadSize(id);

        ModelAndView modelAndView = new ModelAndView("blog/blogview");
        String content = selectBlog(id);
        //System.out.println(content);
        modelAndView.addObject("viewContent" , content);
        //System.out.println("跳转至内容显示页面");
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false,defaultValue = "0") Long id){
        if(id == 0){
            id = blogService.lastId();
        }
        ModelAndView modelAndView = new ModelAndView();
        //String content = selectBlog(id);
        //System.out.println(content);
        Blog blog = blogService.selectBlog(id);
        modelAndView.addObject("blog" , blog);

        modelAndView.setViewName("blog/edit");
        return modelAndView;
    }

    @RequestMapping("/updateBlog")
    public ModelAndView updateBlog(@ModelAttribute Blog blog,@RequestParam(value = "id") Long id, ModelAndView modelAndView){
        //String title = blog.getTitle();
        blogService.updateBlog(blog);
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteBlog(@RequestParam(value = "id", required = false,defaultValue = "0") Long id){
        blogService.deleteBlog(id);
        return new ModelAndView("redirect:/adminBlog");
    }



}
