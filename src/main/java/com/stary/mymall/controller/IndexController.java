package com.stary.mymall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stary.mymall.entity.Product;
import com.stary.mymall.service.IProductService;
import com.stary.mymall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
    public String index() {
        return "forward:/index";
    }
    @RequestMapping("/index")
    public String getIndex(HttpServletRequest request,
                              @RequestParam(value = "msg",defaultValue = "") String msg,
                              @RequestParam(value = "sort",defaultValue = "全部") String sort,
                              @RequestParam(value = "pn", defaultValue = "1") Integer pn) {


        Page<Product> page=new Page<>(pn,4);
        IPage<Product> pageInfo=new Page<>();
        if (sort.equals("全部")){
            pageInfo = productService.selectProductPage(page);
        }
        else{
            //todo 查询对应的种类
            pageInfo= productService.queryPageBySort(page, sort);

        }

        MyPageHelper myPageHelper=new MyPageHelper(pageInfo,sort);
        System.out.println("myPagehelper==="+myPageHelper);
        request.setAttribute("pageInfo", myPageHelper);
        request.setAttribute("msg",msg);
        return "mall/index";

    }

}
