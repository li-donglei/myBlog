# myblog博客项目v0.1

[TOC]

### 技术栈

- springboot
- thymeleaf
- mybatis
- Jquery
- editormd
- mysql5.5
- ElasticSearch搜索功能（后期加强）



### 目录结构

```ht
├──myblog
│  ├──src
│  │  ├──main
│  │  │  ├──java
│  │  │  │  ├──com.donglei.myblog
│  │  │  │  │  ├──controller
│  │  │  │  │  │  ├──BackstageController.java				//后台控制器
│  │  │  │  │  │  ├──BlogController.java					//博客编辑、查看控制器
│  │  │  │  │  │  └──MainController.java					//主控制器
│  │  │  │  │  ├──entity
│  │  │  │  │  │  └──Blog.java								//Blog实体，对应数据库
│  │  │  │  │  ├──interceptor
│  │  │  │  │  │  ├──AdminLoginAdapter.java					//WebMvc过滤器
│  │  │  │  │  │  └──AdminLoginInterceptor.java
│  │  │  │  │  ├──mapper
│  │  │  │  │  │  └──BlogMapper.java						//BlogMapper映射
│  │  │  │  │  ├──service
│  │  │  │  │  │  └──BlogService.java
│  │  │  │  │  └──MyBlogApplication.java
│  │  └──test
│  │  │  └──resources
│  │  │  │  ├──static
│  │  │  │  │  ├──css
│  │  │  │  │  ├──fonts
│  │  │  │  │  ├──fonts-icomoon
│  │  │  │  │  ├──images
│  │  │  │  │  ├──js
│  │  │  │  │  ├──lib
│  │  │  │  │  └──plugins
│  │  │  │  ├──templates
│  │  │  │  │  ├──backstage
│  │  │  │  │  ├──blog
│  │  │  │  │  ├──segments
│  │  │  │  │  └──index.html
│  │  │  │  │  │  └──application.yml
│  ├──target
│  ├──pom.xml
│  └──readme.md

```


### 功能规划

#### 数据库设计

1、blog:

id(long文章的id), 

title(varchar(100)文章标题) ，

summary(text,文章摘要)，

catalog(文章分类)，

content(text 文章内容，存储markdown语法格式), 

createtime(创作时间（time)),

readSize(int，访问量，阅读量)，

commentSize（int,评论量），

voteSize(int,点赞量)

comment(评论)

#### 博客

查看

#### 评论

#### 点赞

#### 后台管理

admin

#### 登陆验证页面

blogedit、admin、edit
