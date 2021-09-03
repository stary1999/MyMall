package com.stary.mymall.controller;

import com.alibaba.fastjson.JSONObject;
import com.stary.mymall.entity.User;
import com.stary.mymall.service.UserService;
import com.stary.mymall.utils.BackJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
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
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String getLogin(){
        return "mall/mall_login";
    }

    @PostMapping("/login")
    public String userLogin(HttpSession session,
                            HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "remember",required = false,defaultValue = "false") String remember
//                            @RequestParam(value = "code") String code
                            ){


        //账号校验
        System.out.println("user==="+username+"  "+password);
        Boolean login = userService.login(username, password);
        if (login){
            User user = userService.getUser(username);
            //登录成功，防止表单重复提交，可以重定向到主页
            if (remember.equals("true")){
//                创建登录用户名Cookie
                Cookie cook_name=new Cookie("username",username);
                //创建登录用户密码Cookie
                Cookie cook_pwd=new Cookie("password",password);
                //设置过期时间为**秒
                cook_name.setMaxAge(60*60*24);
                cook_pwd.setMaxAge(60*60*24);
                //将Cookie写入客户端
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.addCookie(cook_name);
                response.addCookie(cook_pwd);
            }
            session.setAttribute("loginUser",user);
            session.setAttribute("username",username);
            if (!user.getUserAdmin().equals(0)){
                return "redirect:/admin/index";
            }else {
                return "redirect:/index";
            }

        }
        else {
            //登录失败
//            map.put("msg","用户名或密码错误");
            String msg="账号或密码错误";
            request.setAttribute("msg",msg);
            return "mall/mall_login";
        }

    }

    @RequestMapping("/loginOut")
    public String getLoginOut(HttpSession session){
        session.removeAttribute("loginUser");
        session.removeAttribute("username");
        return "redirect:/index";

    }


    @GetMapping("/register")
    public String getRegister(){
        return "mall/mall_register";
    }

    @GetMapping("/getUser/Name")
    @ResponseBody
    public Boolean getName(@RequestParam(value = "username") String username){
        //数据库查询
        Boolean name = userService.getName(username);

        System.out.println("username==="+username);
        if (name){
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
        Boolean email1 = userService.getEmail(email);
        System.out.println("email==="+email);
        if (email1){
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
        //后端再校验一遍 todo
        //
        // 判断数据库
        User user=new User(0,username,password,email,0);
        Boolean aBoolean = userService.addUser(user);
        String msg;
        if (aBoolean){
            msg="注册成功！";
        }
        else {
            msg="注册失败！";
        }

        request.setAttribute("msg",msg);
        return "mall/mall_register";

    }
}
