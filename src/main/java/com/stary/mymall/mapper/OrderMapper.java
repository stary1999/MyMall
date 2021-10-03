package com.stary.mymall.mapper;

import com.stary.mymall.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname OrderMapper
 * @description
 * @create 2021/10/3-16:26
 */
@Mapper
public interface OrderMapper {

    //查询某个用户的所有订单
    List<Order> queryOrderByUser(String userId);

    //查询订单号订单
    Order queryOrderByOrder(String orderId);

    //添加订单
    Boolean addOrder(Order order);

    //修改订单状态
    Boolean updateOrderStatus(@Param("orderId") String orderId, @Param("orderStatus") String orderStatus);

    //删除订单

    //查询所有订单
    List<Order> queryOrderAll();



}
