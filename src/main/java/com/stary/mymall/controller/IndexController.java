package com.stary.mymall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stary.mymall.entity.Product;
import com.stary.mymall.service.IProductService;
import com.stary.mymall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname IndexController
 * @description
 * @create 2021/8/28-9:00
 */
@Controller
public class IndexController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/")
    public ModelAndView index(ModelAndView modelAndView,
                              @RequestParam(value = "pn", defaultValue = "1") Integer pn) {


        Page<Product> page=new Page<>(pn,3);
        IPage<Product> pageInfo = productService.selectProductPage(page);
        MyPageHelper myPageHelper=new MyPageHelper(pageInfo);
        System.out.println("myPagehelper==="+myPageHelper);


        modelAndView.addObject("pageInfo", myPageHelper);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/index")
    public ModelAndView getIndex(ModelAndView modelAndView,
                              @RequestParam(value = "pn", defaultValue = "1") Integer pn) {


        Page<Product> page=new Page<>(pn,3);
        IPage<Product> pageInfo = productService.selectProductPage(page);
        MyPageHelper myPageHelper=new MyPageHelper(pageInfo);
        System.out.println("myPagehelper==="+myPageHelper);


        modelAndView.addObject("pageInfo", myPageHelper);
        modelAndView.setViewName("index");
        return modelAndView;
    }



}
