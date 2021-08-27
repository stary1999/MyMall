package com.stary.mymall.daoUser;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author stary
 * @version 1.0
 * @classname druidTest
 * @description
 * @create 2021/8/27-13:05
 */

@Slf4j
@SpringBootTest
public class druidTest {

    @Autowired
    DataSource dataSource;


    @Test
    public void test() throws SQLException {
        //获取连接
        Connection connection = dataSource.getConnection();
        log.info("connection获取连接");
        System.out.println("class===="+dataSource.getClass());

        //Statement接口
        Statement statement = connection.createStatement();
        String sql1 = "select count(*) from product";
        ResultSet resultSet = statement.executeQuery(sql1);
        log.info("resultset====" + resultSet);


        //关闭连接
        connection.close();
        log.info("connection.close();");

    }
}
