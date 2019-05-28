package com.donglei.blog.mapper;

import com.donglei.blog.entity.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogMapper {


    @Insert("insert into blog(id,  title,  summary,  content, createtime, readsize, commentsize, votesize,  catalog) values(#{id},#{title},#{summary},#{content},#{createtime},#{readsize}, #{commentsize}, #{votesize},#{catalog})")
    void insertBlog(Blog blog);

    @Select("select * from blog where id = #{id}")
    Blog selectById(Long id);

    @Select("select * from blog order by id desc")
    List<Blog> selectBlog();

    @Select("select max(id) from blog")
    Long lastId();

    @Update("update blog set readsize = readsize+1 where id=#{id}")
    void updateReadSize(Long id);

    @Update("update blog set title=#{title},summary=#{summary},content=#{content},createtime=#{createtime},catalog=#{catalog} where id = #{id}")
    void updateBlog(Blog blog);

    @Delete("delete from blog where id=#{id}")
    void deleteBlog(Long id);
}
