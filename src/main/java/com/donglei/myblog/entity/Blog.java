package com.donglei.myblog.entity;

import java.io.Serializable;

public class Blog implements Serializable {
    private Integer id = 1;
    private String content;

    public Blog() {
    }

    public Blog(String content) {
        this.content = content;
    }
    public Blog(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
