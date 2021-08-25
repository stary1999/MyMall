package com.stary.mymall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author stary
 * @version 1.0
 * @classname AdminManager
 * @description
 * @create 2021/8/25-16:39
 */
@Controller
@RequestMapping("/admin")
public class AdminsController {
    @RequestMapping("/adminsManager")
    public String adminManager(){
        return "/admin/admins_Manager";
    }
}
