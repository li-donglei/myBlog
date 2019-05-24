package com.donglei.myblog.mapper;

import com.donglei.myblog.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogMapper {


    @Insert("insert into blog(title,summary,content,createtime,catalog) values(#{title},#{summary},#{content},#{createtime},#{catalog})")
    void insertBlog(Blog blog);

    @Select("select * from blog where id = #{id}")
    Blog selectById(Integer id);

    @Select("select * from blog")
    List<Blog> selectBlog();

    @Select("select max(id) from blog")
    int lastId();

    @Update("update blog set readsize = readsize+1 where id=#{id}")
    void updateReadSize(Integer id);

    @Update("update blog set title=#{title},summary=#{summary},content=#{content},createtime=#{createtime},catalog=#{catalog} where id = #{id}")
    void updateBlog(Blog blog);
}
