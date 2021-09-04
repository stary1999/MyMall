package com.stary.mymall.entity;

import lombok.Data;

/**
 * @author stary
 * @version 1.0
 * @classname OrderItem
 * @description
 * @create 2021/9/4-12:35
 */
@Data
public class OrderItem {
    private String orderId;
    private String productId;
    private String productName;
    private String productPrice;
    private String productCount;
    private String productTotalPrice;
}
