package com.stary.mymall.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.stary.mymall.entity.Order;
import com.stary.mymall.entity.User;
import com.stary.mymall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname OrdersController
 * @description
 * @create 2021/8/25-16:32
 */
@Controller
@RequestMapping("/admin")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/ordersManager")
    public String getOrdersManager(){
        return "/admin/orders_manager";
    }

    @GetMapping("/getOrders")
    @ResponseBody
    public String getOrders(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String userId =String.valueOf(user.getUserId()) ;
        //调用
        List<Order> orders = orderService.queryOrderAll();

        JSONArray jsonArray=new JSONArray();
        jsonArray.add(orders);

        String s=jsonArray.toString();
        String newString=jsonArray.toString().substring(1,s.length()-1);
        return newString;
    }

}
