package com.stary.mymall.service;

import com.stary.mymall.entity.Cart;
import com.stary.mymall.entity.CartItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @author stary
 * @version 1.0
 * @classname CarServiceTest
 * @description
 * @create 2021/9/1-18:03
 */
@SpringBootTest
public class CarServiceTest {
    @Autowired
    private CarService carService;

    @Test
    void addCarTest(){

        String userId="0025";
        String productId="5";
        String productId2="6";
        String productId3="8";
        carService.addToCar(userId,productId);
        carService.addToCar(userId,productId2);
        carService.addToCar(userId,productId2);
        carService.addToCar(userId,productId3);
        carService.addToCar(userId,productId3);
        carService.addToCar(userId,productId3);
        Cart cart = carService.queryToCar(userId);
        System.out.println("===========");
        System.out.println("cart=="+cart.toString());
        System.out.println("cart=="+cart.getUserId()+"  "+cart.getTotalCount()+"  "+cart.getTotalPrice());
        for (Map.Entry<Integer, CartItem> entry:cart.getItemMap().entrySet()){
            System.out.println("cartItem=="+entry.getKey()+"  "+entry.getValue());
        }
//        String userId="0025";
//        String productId="3379";
//        Boolean aBoolean = carService.addToCar(userId, productId);
//        Map<Object, Object> objectObjectMap = carService.queryToCar(userId);
//        for (Map.Entry<Object,Object> entry:objectObjectMap.entrySet()){
//            System.out.println("key=="+entry.getKey()+"   value="+entry.getValue());
//            System.out.println("========");
//        }
//        String productId2="6379";
//        carService.addToCar(userId,productId);
//        carService.addToCar(userId,productId2);
//
//        Map<Object, Object> objectObjectMap2 = carService.queryToCar(userId);
//        for (Map.Entry<Object,Object> entry:objectObjectMap2.entrySet()){
//            System.out.println("key=="+entry.getKey()+"   value="+entry.getValue());
//        }


    }
    @Test
    void reduceToCarTest(){
//        String userId="0025";
//        String productId="3379";
//        System.out.println("====减之前====");
//        Cart cart=carService.queryToCar(userId);
//
//        System.out.println("=====减之后===");
//        Boolean aBoolean = carService.reduceToCar(userId, productId);
//        Map<Object, Object> objectObjectMap2 = carService.queryToCar(userId);
//        for (Map.Entry<Object,Object> entry:objectObjectMap2.entrySet()){
//            System.out.println("key=="+entry.getKey()+"   value="+entry.getValue());
//
//        }
//
//        System.out.println("=====删除之后===");
//        carService.deleteToCar(userId);
//
//        Map<Object, Object> objectObjectMap3 = carService.queryToCar(userId);
//        for (Map.Entry<Object,Object> entry:objectObjectMap3.entrySet()){
//            System.out.println("key=="+entry.getKey()+"   value="+entry.getValue());
//
//        }



    }
}
