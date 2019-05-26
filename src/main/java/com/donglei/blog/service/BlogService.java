package com.donglei.blog.service;

import com.donglei.blog.entity.Blog;
import com.donglei.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    public BlogMapper blogMapper;

    public Blog selectBlog(Long id){
        return blogMapper.selectById(id);
    }

    public String insertBlog(Blog blog){
        blogMapper.insertBlog(blog);
        return "SUCCESS";
    }

    public List<Blog> selectBlog(){

        return blogMapper.selectBlog();
    }

    public Long lastId(){
        return blogMapper.lastId();
    }

    public void updateReadSize(Long id){
        blogMapper.updateReadSize(id);
    }

    public void updateBlog(Blog blog){
        blogMapper.updateBlog(blog);
    }

    public void deleteBlog(Long id){
        blogMapper.deleteBlog(id);
    }

}
