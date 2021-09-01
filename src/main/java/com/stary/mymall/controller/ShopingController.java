package com.stary.mymall.controller;

import com.stary.mymall.entity.Cart;
import com.stary.mymall.entity.Product;
import com.stary.mymall.service.CarService;
import com.stary.mymall.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author stary
 * @version 1.0
 * @classname ShopingController
 * @description
 * @create 2021/9/1-18:37
 */
@Controller
public class ShopingController {
    @Autowired
    private CarService carService;


    @RequestMapping("addToCart")
    public String getAddToCart(HttpServletRequest request,
                               @RequestParam(value = "productId", defaultValue = "0") String productId) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();

            String cookieValue = cookie.getValue();
        }
        //todo 根据cookie获得用户Id
        String userId = "001";
        Boolean aBoolean = carService.addToCar(userId, productId);

        String msg = "?msg="+Msg.MsgUtils(aBoolean, "添加购物车");


        return "forward:/index" + msg;

    }
    @RequestMapping("/getCar")
    public String getCar(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();

            String cookieValue = cookie.getValue();
        }
        //todo 根据cookie获得用户Id
        String userId = "001";

        Cart cart = carService.queryToCar(userId);

        System.out.println(cart);
        return "";
    }


}
