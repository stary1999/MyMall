package com.stary.mymall.entity;

import lombok.*;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @author stary
 * @version 1.0
 * @classname Person
 * @description
 * @create 2021/8/24-22:55
 */
//无参构造
@NoArgsConstructor
//全参构造
@AllArgsConstructor
//get、set
@Data
@ToString
@EqualsAndHashCode
public class Person {
    private int userId;
    private String userName;
    private int userAge;


}
