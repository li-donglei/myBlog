package com.donglei.blog.service;

import com.donglei.blog.entity.Blog;
import com.donglei.blog.mapper.BlogMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

//    public List<Blog> selectBlog(){
//
//        return blogMapper.selectBlog();
//    }
    /**
     * 实现分页功能
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Blog> selectBlog(int pageNo, int pageSize){

        PageHelper.startPage(pageNo,pageSize);
        List<Blog> list = blogMapper.selectBlog();
        //用PageInfo对结果进行包装
        PageInfo<Blog> page = new PageInfo<Blog>(list);
        return page;

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
