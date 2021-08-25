package com.stary.mymall.controller.admin;

import com.stary.mymall.utils.backJson;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.HttpResource;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author stary
 * @version 1.0
 * @classname Admin
 * @description
 * @create 2021/8/24-18:23
 */

@RestController
public class Admin {

    @RequestMapping("/admin")
    public ModelAndView adminIndex(ModelAndView modelAndView){

        modelAndView.setViewName("admin/admin_Login");

        return modelAndView;
    }

    @PostMapping(value = "/admin/login")
    public ModelAndView login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(defaultValue =  "no") String remember,
                              HttpServletResponse httpResponse,
                              ModelAndView modelAndView) throws IOException {
        //判断是否登录
        //TODO
        System.out.println("userName="+username);
        System.out.println("password="+password);
        System.out.println("remember="+remember);
        if(remember.equals("remember-me")){
            //todo 生成cookie

        }

        //todo 验证账号密码
        if(username.equals("aa@aa.aa")&&password.equals("aa")){
            modelAndView.addObject("adminId","001");

            modelAndView.setViewName("admin/admin_Index");
            return modelAndView;
        }

        modelAndView.addObject("msg","账号或密码错误，请重试");

        modelAndView.setViewName("forward:/admin");

        return modelAndView;
    }


}

//@RestController
//public class ParameterTestController {
//
//
//    //  car/2/owner/zhangsan
//    @GetMapping("/car/{id}/owner/{username}")
//    public Map<String,Object> getCar(@PathVariable("id") Integer id,
//                                     @PathVariable("username") String name,
//                                     @PathVariable Map<String,String> pv,
//                                     @RequestHeader("User-Agent") String userAgent,
//                                     @RequestHeader Map<String,String> header,
//                                     @RequestParam("age") Integer age,
//                                     @RequestParam("inters") List<String> inters,
//                                     @RequestParam Map<String,String> params,
//                                     @CookieValue("_ga") String _ga,
//                                     @CookieValue("_ga") Cookie cookie){
//
//
//        Map<String,Object> map = new HashMap<>();
//
////        map.put("id",id);
////        map.put("name",name);
////        map.put("pv",pv);
////        map.put("userAgent",userAgent);
////        map.put("headers",header);
//        map.put("age",age);
//        map.put("inters",inters);
//        map.put("params",params);
//        map.put("_ga",_ga);
//        System.out.println(cookie.getName()+"===>"+cookie.getValue());
//        return map;
//    }
