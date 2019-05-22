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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//    @Value("")
//    String folder = System.getProperty("user.dir")+File.separator+"upload"+File.separator;

        /**

         * 在配置文件中配置的文件保存路径

         */
        public JSONObject upload(HttpServletRequest request, @RequestParam(value = "editormd-image-file", required = false) MultipartFile file) throws Exception {

            String fileName = file.getOriginalFilename();

            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

            String newFileName = new Date().getTime() + "." + suffix;

            File localFile = new File(folder, newFileName);

            file.transferTo(localFile);


            JSONObject res = new JSONObject();
            res.put("success",1);
            res.put("message","上传成功");
            res.put("url","upload/"+newFileName);
            return res;

        }
}
