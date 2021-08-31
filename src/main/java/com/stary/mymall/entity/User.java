package com.stary.mymall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author stary
 * @version 1.0
 * @classname User
 * @description
 * @create 2021/8/31-20:50
 */

/*
* userAdmin,0:root管理员，1：一般管理员，2：仅有查看权限的管理员，3、4留作备用，5：用户。
* 3,4：拟，只读、只写，只能看订单??
* */
@Data
@AllArgsConstructor
public class User {

    private Integer userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private Integer userAdmin;

}
