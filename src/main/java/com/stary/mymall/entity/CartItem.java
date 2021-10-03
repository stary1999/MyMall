package com.stary.mymall.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author stary
 * @version 1.0
 * @classname CartItem
 * @description
 * @create 2021/8/31-22:48
 */
@Data
public class CartItem {

    private Integer number;
    private BigDecimal totalPrice;
    private Product product;

}
