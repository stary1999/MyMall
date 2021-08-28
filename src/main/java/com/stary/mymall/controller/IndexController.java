package com.stary.mymall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stary.mymall.entity.Product;
import com.stary.mymall.service.IProductService;
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

//        IPage<User> userPage = new Page<>(2, 2);//参数一是当前页，参数二是每页个数
//        6 userPage = userMapper.selectPage(userPage, null);
//        7 List<User> list = userPage.getRecords();
//        8 for (User user : list) {
//            9 System.out.println(user);
//            10
//        }

        Page<Product> page=new Page<>(pn,2);
        IPage<Product> pageInfo = productService.selectProductPage(page);



        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("index");
        return modelAndView;
    }

//    @RequestMapping("/getIndex")
//    public ModelAndView Index(ModelAndView modelAndView,
//                              @RequestParam(value = "pn", defaultValue = "1") Integer pn){
//        PageHelper.startPage(pn,5);
//
//        List<Product> list = productService.list();
//        PageInfo pageInfo=new PageInfo(list,5);
//        System.out.println("pageInfo==="+pageInfo);
//        System.out.println("pageInfoToString==="+pageInfo.toString());
//
//
////        pageInfo===PageInfo{pageNum=1, pageSize=4, size=4, startRow=0, endRow=3, total=4, pages=1,
////            list=[Product(productId=1, productName=华为p50, productSort=手机, productPrice=5099.00, productStock=100, productImgPath=null), Product(productId=2, productName=小米10, productSort=手机, productPrice=4999.00, productStock=200, productImgPath=null), Product(productId=3, productName=洗衣粉, productSort=百货, productPrice=15.00, productStock=1000, productImgPath=null), Product(productId=4, productName=索尼耳机, productSort=数码, productPrice=399.00, productStock=500, productImgPath=null)],
////        prePage=0, nextPage=0, isFirstPage=true, isLastPage=true, hasPreviousPage=false, hasNextPage=false, navigatePages=5, navigateFirstPage1, navigateLastPage1, navigatepageNums=[1]}
////
//        modelAndView.addObject("pageInfo",pageInfo);
//
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }


}
