package com.donglei.myblog.entity;

import java.io.Serializable;

public class Blog implements Serializable {
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private String createtime;
    private Integer readsize;
    private Integer commentsize;
    private Integer votesize;
    private String comment;



    public Blog() {
    }

    public Blog(String title, String summary, String content, String createtime) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getReadsize() {
        return readsize;
    }

    public void setReadsize(Integer readsize) {
        this.readsize = readsize;
    }

    public Integer getCommentsize() {
        return commentsize;
    }

    public void setCommentsize(Integer commentsize) {
        this.commentsize = commentsize;
    }

    public Integer getVotesize() {
        return votesize;
    }

    public void setVotesize(Integer votesize) {
        this.votesize = votesize;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
