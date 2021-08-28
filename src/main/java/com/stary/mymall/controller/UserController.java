package com.stary.mymall.controller;

import com.alibaba.fastjson.JSONObject;
import com.stary.mymall.utils.BackJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author stary
 * @version 1.0
 * @classname User
 * @description
 * @create 2021/8/24-18:22
 */

@Controller
public class UserController {


    @RequestMapping("/login")
    public String userLogin(){
        return "User/login";

    }

    @RequestMapping("/loginUser")
    public String loginUser(){
        //todo

        return "index";
    }

    @RequestMapping("/register")
    public void register(HttpServletResponse response) throws IOException {
        JSONObject jsonObject= new JSONObject();
        Map<String,String> map=new HashMap<>();
        map.put("phone","1223456");
        map.put("status","ok");
        System.out.println("map");
        BackJson.backJson(response,map);

        //
    }
}


//@Controller
//@RequestMapping("/login")
//public class TestController {
//    @RequestMapping("/test")
//    public void test(HttpServletResponse response) throws IOException {
//        SysUser sysUser=new SysUser();
//        sysUser.setLoginPass("123456");
//        sysUser.setLoginAccount("小明");
//        System.out.println("dskfjdsfssdfdsfklkdfdsf");
//        JSONObject jsonObject= (JSONObject) JSONObject.toJSON(sysUser);
//        Map<String,String> map=new HashMap<>();
//        map.put("phone","1223456");
//        map.put("status","ok");
//        jsonObject.put("info",map);
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write(jsonObject.toJSONString());
//    }
//}
//结果如下：
//{"loginAccount":"小明","roles":[],"loginPass":"123456","info":{"phone":"1223456","status":"ok"}}

