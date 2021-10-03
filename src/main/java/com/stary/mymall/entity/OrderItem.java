package com.stary.mymall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author stary
 * @version 1.0
 * @classname OrderItem
 * @description
 * @create 2021/9/4-12:35
 */
@Data
@AllArgsConstructor
public class OrderItem {
    private String orderId;
    private String productId;
    private BigDecimal productPrice;
    private Integer productCount;
}
