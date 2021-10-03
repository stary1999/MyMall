package com.stary.mymall.service.impl;

import com.stary.mymall.entity.Order;
import com.stary.mymall.entity.OrderItem;
import com.stary.mymall.mapper.OrderItemMapper;
import com.stary.mymall.mapper.OrderMapper;
import com.stary.mymall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname OrderServiceImpl
 * @description
 * @create 2021/10/3-16:24
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public Boolean addToOrder(Order order) {
        Boolean aBoolean = orderMapper.addOrder(order);

        for (OrderItem orderItem:order.getOrderItemList()){
            System.out.println("orderItem==="+orderItem);
            orderItemMapper.addOrderItem(orderItem);
        }

        return aBoolean;
    }

    @Override
    public List<Order> queryOrderByUser(String userId) {
        List<Order> orders = orderMapper.queryOrderByUser(userId);

        for (Order order:orders){
            List<OrderItem> orderItems = orderItemMapper.queryOrderItemByOrderId(order.getOrderId());
            order.setOrderItemList(orderItems);
        }

        return orders;
    }

    @Override
    public Order queryOrderByOrder(String orderId) {
        Order order = orderMapper.queryOrderByOrder(orderId);
        List<OrderItem> orderItems = orderItemMapper.queryOrderItemByOrderId(orderId);
        order.setOrderItemList(orderItems);

        return order;
    }

    @Override
    public Boolean updateOrderStatusPost(String orderId) {

        return orderMapper.updateOrderStatus(orderId, "1");
    }

    @Override
    public Boolean updateOrderStatusGet(String orderId) {
        return orderMapper.updateOrderStatus(orderId, "2");
    }

    @Override
    public List<Order> queryOrderAll() {

        List<Order> orders = orderMapper.queryOrderAll();
        for (Order order:orders){
            List<OrderItem> orderItems = orderItemMapper.queryOrderItemByOrderId(order.getOrderId());
            order.setOrderItemList(orderItems);
        }

        return orders;

    }


}
