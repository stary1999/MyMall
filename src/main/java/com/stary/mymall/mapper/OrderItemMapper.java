package com.stary.mymall.mapper;

import com.stary.mymall.entity.Order;
import com.stary.mymall.entity.OrderItem;
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
public interface OrderItemMapper {


    //查询订单号订单项
    List<OrderItem> queryOrderItemByOrderId(String orderId);

    //添加订单项
    Boolean addOrderItem(OrderItem orderItem);

    //删除订单



}
