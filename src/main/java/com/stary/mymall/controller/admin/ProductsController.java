package com.stary.mymall.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stary.mymall.entity.Product;
import com.stary.mymall.service.IProductService;
import com.stary.mymall.service.impl.ProductServiceImpl;
import com.stary.mymall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView ProductsManager(ModelAndView modelAndView,
                                        @RequestParam(value = "pn", defaultValue = "1") Integer pn) {

        Page<Product> page=new Page<>(pn,2);
        IPage<Product> pageInfo = productService.selectProductPage(page);
        MyPageHelper myPageHelper=new MyPageHelper(pageInfo);
        System.out.println("myPagehelper==="+myPageHelper);


        modelAndView.addObject("pageInfo", myPageHelper);
        modelAndView.setViewName("admin/products_Manager");
        return modelAndView;
    }

    @RequestMapping("/productsUpdata")
    public ModelAndView ProductsUpdata(ModelAndView modelAndView){
        return modelAndView;

    }

    @RequestMapping("/productsDelete")
    public ModelAndView ProductsDelete(ModelAndView modelAndView){
        return modelAndView;

    }

    @RequestMapping("/productsAdd")
    public ModelAndView ProductsAdd(ModelAndView modelAndView){
        modelAndView.setViewName("admin/products_Manager_Add");
        return modelAndView;
    }

    @RequestMapping("/productsAddTo")
    public ModelAndView ProductsAddTo(ModelAndView modelAndView){

        return modelAndView;
    }




//    @RequestMapping("/getProducts")
//    public ModelAndView getProducts(ModelAndView modelAndView,
//        @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
//
//            Page<Product> page=new Page<>(pn,2);
//            IPage<Product> pageInfo = productService.selectProductPage(page);
//            MyPageHelper myPageHelper=new MyPageHelper(pageInfo);
//            System.out.println("myPagehelper==="+myPageHelper);
//
//
//            modelAndView.addObject("pageInfo", myPageHelper);
//            modelAndView.setViewName("admin/products_Manager");
//            return modelAndView;
//    }

}
