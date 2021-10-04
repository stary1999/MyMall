package com.stary.mymall.service;

import com.stary.mymall.entity.User;

import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname UserService
 * @description
 * @create 2021/9/2-22:26
 */
public interface UserService {
    public Boolean addUser(User user);

    public Boolean login(String name,String password);

    public Boolean getName(String name);

    public Boolean getEmail(String email);

    public User getUser(String name);

    List<User> getUserAll();
    List<User> getUserAllForAdmin();

}
