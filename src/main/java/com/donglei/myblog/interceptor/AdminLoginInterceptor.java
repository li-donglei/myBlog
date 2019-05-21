package com.donglei.myblog.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        Object admin = session.getAttribute("name");
        Object passwd = session.getAttribute("passwd");
//        System.out.println("admin====="+admin);

        List<String> a = new ArrayList<>();

//        Cookie[] cookies = request.getCookies();
//        System.out.println(cookies[0].getValue());
        if(admin!=null&&"admin".equals(admin)&&"123".equals(passwd)){
            return true;
        }else{
            //            不存在则跳转到登录页
            response.sendRedirect("/login");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}



