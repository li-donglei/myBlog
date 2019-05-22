# myblog博客项目v0.1

### 技术栈

- springboot
- thymeleaf
- mybatis
- Jquery
- editormd
- mysql5.5
- ElasticSearch搜索功能（后期加强）



### 目录结构

| —— main/java/com.donglei.blog

* controller :  控制层
  * BlogController :   博客编写页面的控制层
  * MainController ：  与首业相关的控制层
* entity :  pojo数据库映射实体
  * Blog :  博客文章存储实体
* Mapper
  * BlogMapper：Blog映射
* Service
  * BlogService：数据库相关操作  service层
* MyblogApplication.java 

* resources
  * static：存放静态资源，包括css\js\images...
  * templates：thymeleaf解析的模板文件，html文件
    * blog：博客文章编辑相关页面
      * simple.html：博文markdown编辑页面
      * view.html：博文编辑完展示页面
    * index.html ：首页
  * application.yml：springboot项目配置文件

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

查看，编辑

#### 评论

#### 点赞

#### 后台管理

admin

#### 登陆验证页面

blogedit、admin

