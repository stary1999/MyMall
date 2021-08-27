package com.stary.mymall.controller.admin;

import com.stary.mymall.entity.Product;
import com.stary.mymall.service.IProductService;
import com.stary.mymall.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    @Autowired
    private IProductService productService;

    @RequestMapping("/productsManager")
    public ModelAndView productsManager(ModelAndView modelAndView){
        modelAndView.setViewName("admin/products_Manager");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/getProducts")
    public String getProducts(){
        List<Product> list = productService.list();
        for (Product p:list){
            System.out.println(p);
        }

        return list.toString();
    }

}
