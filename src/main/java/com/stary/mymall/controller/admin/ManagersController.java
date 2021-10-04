package com.stary.mymall.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.stary.mymall.entity.User;
import com.stary.mymall.mapper.UserMapper;
import com.stary.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname AdminManager
 * @description
 * @create 2021/8/25-16:39
 */
@Controller
@RequestMapping("/admin")
public class ManagersController {

    @Autowired
    private UserService userService;

    @RequestMapping("/managersManager")
    public String getManagersManager(){
        return "/admin/managers_manager";
    }

    @RequestMapping("/getUserAdmin")
    @ResponseBody
    public String getUserAdmin(){
        List<User> userAll = userService.getUserAllForAdmin();


        JSONArray jsonArray=new JSONArray();
        jsonArray.add(userAll);

        String s=jsonArray.toString();
        String newString=jsonArray.toString().substring(1,s.length()-1);

        return newString;
    }
}
