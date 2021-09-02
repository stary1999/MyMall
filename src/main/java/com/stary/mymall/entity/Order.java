package com.stary.mymall.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author stary
 * @version 1.0
 * @classname Order
 * @description
 * @create 2021/9/2-9:07
 */
@Data
public class Order {
    private String orderId;
    private String userId;
    private BigDecimal totalPrice;
    private Cart cart;
    private String state;
}
