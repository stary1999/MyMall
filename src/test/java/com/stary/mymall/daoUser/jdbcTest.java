package com.stary.mymall.daoUser;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author stary
 * @version 1.0
 * @classname jdbc
 * @description
 * @create 2021/8/27-12:16
 */
//日志开发
@Slf4j
@SpringBootTest
public class jdbcTest {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void contextLoads() {
        log.info("log 开始");
        System.out.println("sout开始");

        Long aLong = jdbcTemplate.queryForObject("select count(*) from product", Long.class);
        log.info("记录总数：{}",aLong);
        System.out.println("sout记录数"+aLong);
        log.info("info massage");
        log.debug("debug massage");
        log.warn("warn massage");
        log.error("error massage");
        log.trace("trace massage");
        System.out.println("=====分割线");
    }
}
