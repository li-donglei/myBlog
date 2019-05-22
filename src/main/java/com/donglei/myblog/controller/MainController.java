package com.donglei.myblog.controller;


import com.alibaba.fastjson.JSONObject;
import com.donglei.myblog.entity.Blog;
import com.donglei.myblog.service.BlogService;
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
    public ModelAndView index(ModelAndView mv){
        mv.setViewName("index");
        List<Blog> blog= blogService.selectBlog();
        Collections.reverse(blog);//blog逆序
        mv.addObject("blog",blog);
        return mv;
    }


        @RequestMapping("/file")
        /**
         * 在配置文件中配置的文件保存路径
         */
        public JSONObject upload(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file)
                throws Exception {
            String fileName = file.getOriginalFilename();
            System.out.println("fileName" + fileName);
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            System.out.println("suffix" + suffix);
            String newFileName = new Date().getTime() + "." + suffix;
            System.out.println("newFileName" + newFileName);

            File localFile = new File(folder, newFileName);
            file.transferTo(localFile);

            JSONObject res = new JSONObject();
            res.put("success",1);
            res.put("message","上传成功");
            res.put("url","upload/"+newFileName);
            System.out.println("res: "+res);
            return res;

        }
}
