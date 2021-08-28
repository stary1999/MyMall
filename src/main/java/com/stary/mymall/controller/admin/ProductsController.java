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

import java.math.BigDecimal;
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

        Page<Product> page=new Page<>(pn,4);
        IPage<Product> pageInfo = productService.selectProductPage(page);
        MyPageHelper myPageHelper=new MyPageHelper(pageInfo);
        System.out.println("myPagehelper==="+myPageHelper);


        modelAndView.addObject("pageInfo", myPageHelper);
        modelAndView.setViewName("admin/products_Manager");
        return modelAndView;
    }

    @RequestMapping("/productsUpdate")
    public ModelAndView ProductsUpdate(ModelAndView modelAndView){
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
    public String ProductsAddTo(ModelAndView modelAndView,
                                      @RequestParam(value = "productName",defaultValue = "null") String productName,
                                      @RequestParam(value = "productSort",defaultValue = "null") String productSort,
                                      @RequestParam(value = "productPrice",defaultValue = "0") BigDecimal productPrice,
                                      @RequestParam(value = "productDescript",defaultValue = "null") String productDescript,
                                      @RequestParam(value = "productStock",defaultValue = "0") Integer productStock,

                                      @RequestParam(value = "productImgPath",defaultValue = "null") String productImgPath){


        Product product=new Product(0,productName,productSort,productPrice,productDescript,productStock,productImgPath);
        int i = productService.addProduct(product);
//        System.out.println("product===="+productName);
//        System.out.println("product===="+productSort);
//        System.out.println("product===="+productPrice);
//        System.out.println("product===="+productStock);
//        System.out.println("product===="+productDescript);
//        System.out.println("product===="+productImgPath);
//        System.out.println("product===="+productName);

        //todo 文件上传功能
        String msg;
        if (i!=-1){
            msg="添加成功";
        }
        else {
            msg="添加失败";
        }

        modelAndView.addObject("msg",msg);

        modelAndView.setViewName("forward:/admin/productsManager?pn=-1");
        modelAndView.setViewName("redirect:/admin/productsManager?&pn=-1");

        return  "redirect:/admin/productsManager"+"?pn=-1";
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
