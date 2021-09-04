package com.stary.mymall.controller;

import com.stary.mymall.entity.Cart;
import com.stary.mymall.entity.Product;
import com.stary.mymall.entity.User;
import com.stary.mymall.service.CarService;
import com.stary.mymall.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @ResponseBody
    public Boolean getAddToCart(HttpServletRequest request,
                               @RequestParam(value = "productId", defaultValue = "0") String productId) {

        System.out.println("productId===" + productId);
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        //根据session获得用户Id
        String userId = String.valueOf(loginUser.getUserId());
        Boolean aBoolean = false;
        if (productId.equals("0")) {
            //返回失败
//            String msg =Msg.MsgUtils(aBoolean, "添加购物车");
            return false;

        }

        aBoolean = carService.addToCar(userId, productId);

//        String msg =  Msg.MsgUtils(aBoolean, "添加购物车");

        return aBoolean;

    }

    @RequestMapping("/getCar")
    public String getCar(HttpServletRequest request) {

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        //根据session获得用户Id
        String userId = String.valueOf(loginUser.getUserId());

        Cart cart = carService.queryToCar(userId);

        request.setAttribute("cart", cart);
        System.out.println(cart);
        return "mall/mall_cart";
    }


}
