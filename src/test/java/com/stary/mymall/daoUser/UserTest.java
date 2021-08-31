package com.stary.mymall.daoUser;

import com.stary.mymall.entity.User;
import com.stary.mymall.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author stary
 * @version 1.0
 * @classname UserTest
 * @description
 * @create 2021/8/31-20:57
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void queryByIdTest(){
        User user = userMapper.queryById(0);
        System.out.println(user);
    }
    @Test
    void addUserTest(){
        User user=new User(0,"test","test","test@test.test",5);
        Boolean aBoolean = userMapper.addUser(user);
        System.out.println("aboolean======"+aBoolean);
    }

}
