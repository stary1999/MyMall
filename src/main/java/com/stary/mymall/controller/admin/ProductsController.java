package com.stary.mymall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author stary
 * @version 1.0
 * @classname ProductController
 * @description
 * @create 2021/8/25-16:16
 */
@Controller
@RequestMapping("/admin")
public class ProductsController {

    @RequestMapping("/productsManager")
    public String productsManager(){
        return "admin/products_Manager";
    }

}
