package com.stary.mymall.service.impl;

import com.stary.mymall.entity.User;
import com.stary.mymall.mapper.UserMapper;
import com.stary.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname UserServiceImpl
 * @description
 * @create 2021/9/2-22:09
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //注册用户
    public Boolean addUser(User user){
        return userMapper.addUser(user);
    }
    //判断用户是否登录成功

    public Boolean login(String name,String password){
        User user = userMapper.queryByName(name);
        if (user==null){
            return false;
        }
        else  if (user.getUserPassword().equals(password)){
            return true;
        }

        else {
            return false;
        }
    }
    // 返回user对象的id以及整个对象，方便后续操作，id用来作购物车的主键。必须保证在login之后使用
    public User getUser(String name){
        return userMapper.queryByName(name);
    }


    //ajax 用户注册姓名校验
    public Boolean getName(String name){
        User user = userMapper.queryByName(name);
        if (user!=null){
            return true;
        }
        else{
            return false;
        }

    }
    //ajax 用户注册姓名校验
    public Boolean getEmail(String email){
        User user = userMapper.queryByEmail(email);
        if (user!=null){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public List<User> getUserAll() {
        return userMapper.queryUserAll();
    }

    @Override
    public List<User> getUserAllForAdmin() {
        return userMapper.queryUserAllForAdmin();
    }

}
