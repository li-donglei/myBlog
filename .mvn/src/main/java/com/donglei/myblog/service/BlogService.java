package com.donglei.myblog.service;

import com.donglei.myblog.entity.Blog;
import com.donglei.myblog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    public BlogMapper blogMapper;

    public Blog selectBlog(Integer id){
        return blogMapper.selectById(id);
    }

    public String insertBlog(Blog blog){
        blogMapper.insertBlog(blog);
        return "SUCCESS";
    }

    public int lastId(){
        return blogMapper.lastId();
    }

}
