package com.stary.mymall.daoUser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stary.mymall.entity.Product;
import com.stary.mymall.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.math.BigDecimal;

/**
 * @author stary
 * @version 1.0
 * @classname RedisTest
 * @description
 * @create 2021/8/31-19:32
 */

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;



    @Test
    public void set(){
//        redisTemplate.opsForValue().set("myKey","myValue");
        BigDecimal price=new BigDecimal(50);
        Product product=new Product(0,"茶壶","百货",price,
                "来一杯tea吧",50,"/static/image/default.png");

        String s = JSON.toJSON(product).toString();
        redisTemplate.opsForValue().set("product2",s);

        String product2 = redisTemplate.opsForValue().get("product2");

        Product product3 = JSON.parseObject(product2, Product.class);

        System.out.println(product3.toString());


//        String json = JSON.toJSON(user).toString();
//        System.out.println(json);
//        //json字符串转成对象
//        User user1 = JSON.parseObject(json,User.class);
//

    }
    @Test
    public void hsetTest(){
        boolean hset = redisUtil.hset("userId", "productId", "1");
        System.out.println("hset===="+hset);
        Object hget = redisUtil.hget("userId", "productId");
        System.out.println("hget===="+hget);


    }
}
