package com.donglei.blog.controller;


import com.alibaba.fastjson.JSONObject;
import com.donglei.blog.entity.Blog;

import com.donglei.blog.service.BlogService;
import com.donglei.blog.service.PVService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;



@RestController
public class MainController {

    @Value("${img.location}")
    private String folder;

    @Autowired
    BlogController blogController;
    @Autowired
    BlogService blogService;
    @Autowired
    PVService pvService;
    @Autowired
    HttpServletRequest req;
    @RequestMapping({"/","/index","/index.html"})
    //@RequestMapping("/page")
    public ModelAndView index(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                              @RequestParam(value="pageSize",defaultValue="5")int pageSize,
                              ModelAndView modelAndView, HttpServletRequest request){

        // 更新PV访问量
        pvService.updatePV();

        Integer blogNums = blogService.blogNums();
        Integer catalogNums = blogService.catalogNums();

        PageInfo<Blog> page = blogService.selectBlog(pageNo, pageSize);
        modelAndView.addObject("blog",page);
        modelAndView.addObject("PV",pvService.getPV());
        modelAndView.addObject("blogNums",blogNums);
        modelAndView.addObject("catalogNums",catalogNums);
        modelAndView.setViewName("index");

        // 获取访问者IP地址
//        System.out.println("访问者IP: ===>  "+request.getRemoteAddr());
        blogService.insertIP(request.getRemoteAddr());
        return modelAndView;
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
//            System.out.println("res: "+res);
            return res;

        }
}
