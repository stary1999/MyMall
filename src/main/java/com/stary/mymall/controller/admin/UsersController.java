package com.stary.mymall.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.stary.mymall.entity.User;
import com.stary.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname UsersManager
 * @description
 * @create 2021/8/25-16:39
 */
@Controller
@RequestMapping("/admin")
public class UsersController {

    @Autowired
    private UserService userService;
    @RequestMapping("/usersManager")
    public String getUsersManager(){
        return "/admin/users_manager";
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public String getUsers(){
        List<User> userAll = userService.getUserAll();


        JSONArray jsonArray=new JSONArray();
        jsonArray.add(userAll);

        String s=jsonArray.toString();
        String newString=jsonArray.toString().substring(1,s.length()-1);

        return newString;

    }
}
