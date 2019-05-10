package com.donglei.myblog.mapper;

import com.donglei.myblog.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BlogMapper {


    @Insert("insert into blog(title,summary,content,createtime) values(#{title},#{summary},#{content},#{createtime})")
    void insertBlog(Blog blog);

    @Select("select * from blog where id = #{id}")
    Blog selectById(Integer id);

    @Select("select max(id) from blog")
    int lastId();
}
