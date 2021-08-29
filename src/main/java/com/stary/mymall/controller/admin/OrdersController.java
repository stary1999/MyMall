package com.stary.mymall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/ordersManager")
    public String getOrdersManager(){
        return "/admin/orders_manager";
    }

}
