package com.stary.mymall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stary.mymall.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author stary
 * @version 1.0
 * @classname UserMapper
 * @description
 * @create 2021/8/31-20:52
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User queryById(Integer userId);
    Boolean addUser(User user);
}
