package com.stary.mymall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author stary
 * @version 1.0
 * @classname Admin
 * @description
 * @create 2021/8/24-18:23
 */
@Controller
public class Admin {

    @RequestMapping("/admin")
    public String adminIndex(){

        return "admin/admin_Login";
    }

    @RequestMapping("/admin/login")
    public String login() {
        //判断是否登录
        //TODO

        return "admin/admin_Index";
    }

}
