package com.stary.mymall.service;

import com.stary.mymall.entity.Cart;

import java.util.Map;

/**
 * @author stary
 * @version 1.0
 * @classname CarService
 * @description
 * @create 2021/9/1-18:01
 */
public interface CarService{
    public Boolean addToCar(String userId, String productId);
    public Boolean reduceToCar(String userId,String productId);
    public void deleteToCar(String userId);
    public Cart queryToCar(String userId);
}
