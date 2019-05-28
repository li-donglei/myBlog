package com.donglei.blog.controller;


import com.alibaba.fastjson.JSONObject;
import com.donglei.blog.entity.Blog;
import com.donglei.blog.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.*;


@RestController
public class MainController {

    @Value("${img.location}")
    private String folder;

    @Autowired
    BlogController blogController;
    @Autowired
    BlogService blogService;
    @RequestMapping({"/","/index","/index.html"})
    //@RequestMapping("/page")
    public ModelAndView index(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                              @RequestParam(value="pageSize",defaultValue="5")int pageSize,
                              ModelAndView modelAndView){


        PageInfo<Blog> page = blogService.selectBlog(pageNo, pageSize);
        modelAndView.addObject("blog",page);
        modelAndView.setViewName("index");
        return modelAndView;
    }


        @RequestMapping("/file")
        /**
         * 在配置文件中配置的文件保存路径
         */
        public JSONObject upload(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file)
                throws Exception {
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            String newFileName = new Date().getTime() + "." + suffix;

            File localFile = new File(folder, newFileName);
            file.transferTo(localFile);

            JSONObject res = new JSONObject();
            res.put("success",1);
            res.put("message","上传成功");
            res.put("url","http://donglei.fun/images/"+newFileName);
            return res;

        }

}
