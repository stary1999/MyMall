package com.stary.mymall.service;

import com.stary.mymall.entity.Order;

import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname OrderService
 * @description
 * @create 2021/10/3-16:24
 */
public interface OrderService {

    //添加订单
    Boolean addToOrder(Order order);
    //按用户查询订单
    List<Order> queryOrderByUser(String userId);

    //按订单号查询订单
    Order queryOrderByOrder(String orderId);


    //发货
    Boolean updateOrderStatusPost(String orderId);

    //收货
    Boolean updateOrderStatusGet(String orderId);

    //查询所有订单
    List<Order> queryOrderAll();

}
