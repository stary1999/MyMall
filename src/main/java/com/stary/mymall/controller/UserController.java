package com.stary.mymall.controller;

import com.alibaba.fastjson.JSONObject;
import com.stary.mymall.utils.BackJson;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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


    @GetMapping("/login")
    public String getLogin(){
        return "mall/mall_login";
    }

    @PostMapping("/login")
    public String userLogin(HttpSession session,
                            HttpServletRequest request,
                            @RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "remember",required = false) String remember
//                            @RequestParam(value = "code") String code
                            ){

        //todo 账号校验
        if (username.equals("admin")&&password.equals("123")){
            //登录成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            Integer userId=Integer.valueOf("0005");
            session.setAttribute("loginUserId",userId);
            return "redirect:/index";
        }
        else {
            //登录失败
//            map.put("msg","用户名或密码错误");
            String msg="账号或密码错误";
            request.setAttribute("msg",msg);
            return "mall/mall_login";
        }

    }


    @GetMapping("/register")
    public String getRegister(){
        return "mall/mall_register";
    }

    @GetMapping("/getUser/Name")
    @ResponseBody
    public Boolean getName(@RequestParam(value = "username") String username){
        //数据库查询

        System.out.println("username==="+username);
        if (username.equals("admin")){
            return false;
        }
        else {
            return true;
        }
    }
    @GetMapping("/getUser/Email")
    @ResponseBody
    public Boolean getEmail(@RequestParam(value = "email") String email){
        //数据库查询
        System.out.println("email==="+email);
        if (email.equals("aa@aa.aa")){
            return false;
        }
        else {
             return true;
        }
    }


    @PostMapping("/register")
    public String register(HttpServletRequest request,
                           @RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "email") String email

    ) throws IOException {


        System.out.println("username="+username+"  "+password+"  "+email);
        //todo 判断数据库
//        添加数据库
//        JSONObject jsonObject= new JSONObject();
//        Map<String,String> map=new HashMap<>();
//        map.put("phone","1223456");
//        map.put("status","ok");
//        System.out.println("map");
//        BackJson.backJson(response,map);


        String msg="注册成功！";
        request.setAttribute("msg",msg);
        return "mall/mall_register";

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

