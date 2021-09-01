package com.stary.mymall.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author stary
 * @version 1.0
 * @classname Cart
 * @description
 * @create 2021/8/31-22:45
 */
@Data
public class Cart {
    private String userId;
    private Integer totalCount;
    private BigDecimal totalPrice;
    private Map<Integer,CartItem> itemMap=new LinkedHashMap<Integer,CartItem>();

}
