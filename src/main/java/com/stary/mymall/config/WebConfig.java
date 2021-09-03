package com.stary.mymall.config;

import com.stary.mymall.filter.LoginHandlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author stary
 * @version 1.0
 * @classname WebConfig
 * @description
 * @create 2021/8/24-19:57
 */
@Component
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
        //添加一个拦截器
        //SpringBoot已经做好了静态资源映射，可以不用来处理静态资源
        //添加一个拦截器
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index","/","/login","/register","/getUser/**","/static/**");
    }


}
