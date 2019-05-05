# myblog博客项目v0.1

### 技术栈

- springboot
- thymeleaf
- mybatis
- Jquery
- editormd
- mysql5.5



### 目录结构

* main/java/com.donglei.blog
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

#### 博客

#### 评论

#### 点赞



