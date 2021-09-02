package com.stary.mymall.service.impl;

import com.stary.mymall.entity.Cart;
import com.stary.mymall.entity.CartItem;
import com.stary.mymall.entity.Product;
import com.stary.mymall.mapper.ProductMapper;
import com.stary.mymall.service.CarService;
import com.stary.mymall.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author stary
 * @version 1.0
 * @classname CarServiceImpl
 * @description
 * @create 2021/9/1-17:46
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ProductMapper productMapper;

    //添加商品
    public Boolean addToCar(String userId, String productId){
        boolean b = redisUtil.hHasKey(userId, productId);
        if (b){
            Object hget = redisUtil.hget(userId, productId);
            Integer number=(Integer) hget;
            number++;
            boolean hset = redisUtil.hset(userId, productId, number);
            return hset;
        }
        else {
            Integer number=1;
            boolean hset = redisUtil.hset(userId, productId, number);
            return hset;
        }
    }
    //减商品
    public Boolean reduceToCar(String userId,String productId){
        boolean b = redisUtil.hHasKey(userId, productId);
        if (b){
            Object hget = redisUtil.hget(userId, productId);
            Integer number=(Integer) hget;
            number--;
            if(number.equals(0)){
                redisUtil.hdel(userId,productId);
            }
            else {
                redisUtil.hset(userId, productId, number);

            }
            return true;

        }
        else {
            return true;
        }
    }

    //查看所有商品及数量
    public Cart  queryToCar(String userId){

        Cart cart=new Cart();
        cart.setUserId(userId);
        Map<Integer, CartItem> itemMap=new LinkedHashMap<Integer,CartItem>();
        Integer totalCount=0;
        BigDecimal totalPrice=new BigDecimal(0);
        Map<Object, Object> objectObjectMap = redisUtil.hgetAll(userId);
        for (Map.Entry<Object,Object> entry:objectObjectMap.entrySet()){
            Integer productId=Integer.valueOf(entry.getKey().toString());
            Integer number=Integer.valueOf(entry.getValue().toString()) ;
            CartItem cartItem=new CartItem();
            cartItem.setNumber(number);
            Product product = productMapper.queryById(productId);
            cartItem.setProduct(product);
            cartItem.setTotalPrice(product.getProductPrice().multiply(BigDecimal.valueOf(number)));
            itemMap.put(productId,cartItem) ;
            totalCount+=number;
            totalPrice=totalPrice.add(cartItem.getTotalPrice());

        }
        cart.setItemMap(itemMap);
        cart.setTotalCount(totalCount);
        cart.setTotalPrice(totalPrice);

        return cart;
    }


    //删除所有商品
    public void deleteToCar(String userId){
        redisUtil.del(userId);
    }


}
