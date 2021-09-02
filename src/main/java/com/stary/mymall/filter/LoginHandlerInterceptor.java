package com.stary.mymall.filter;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author stary
 * @version 1.0
 * @classname LoginHandlerInterceptor
 * @description
 * @create 2021/9/2-15:51
 */

/*
拦截器的作用就是登陆检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object user = httpServletRequest.getSession().getAttribute("loginUser");
        //判断loginUser是否为空
        if (user == null) {
            //未登录，返回登陆页面
            httpServletRequest.setAttribute("msg", "请先登陆");
            httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest, httpServletResponse);
            return false;
        } else {
            //已登陆，放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}

