package com.stary.mymall.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stary.mymall.entity.Product;
import com.stary.mymall.service.IProductService;
import com.stary.mymall.service.impl.ProductServiceImpl;
import com.stary.mymall.utils.Msg;
import com.stary.mymall.utils.MyPageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname ProductController
 * @description
 * @create 2021/8/25-16:16
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class ProductsController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/productsManager")
    public String getProductsManager(HttpServletRequest request,
                                        @RequestParam(value = "msg",defaultValue = "false") String msg,
                                        @RequestParam(value = "pn", defaultValue = "1") Integer pn) {

        Page<Product> page=new Page<>(pn,4);
        IPage<Product> pageInfo = productService.selectProductPage(page);
        MyPageHelper myPageHelper=new MyPageHelper(pageInfo);
        System.out.println("myPagehelper==="+myPageHelper);
        request.setAttribute("msg",msg);
        request.setAttribute("pageInfo", myPageHelper);
        return "admin/products_manager";
    }

    @RequestMapping("/productsUpdate")
    public String getProductsUpdate(HttpServletRequest HttpServletRequest,
            @RequestParam(value = "productId",defaultValue = "-1") Integer productId){

        Product product = productService.selectProductById(productId);
        System.out.println("product===="+product);

        HttpServletRequest.setAttribute("product",product);
        return "admin/products_manager_update";

    }
    @RequestMapping("/productsUpdateTo")
    public String getProductsUpdateTo(HttpServletRequest httpServletRequest,
                                      @RequestParam(value = "productId",defaultValue = "-1") Integer productId,
                                      @RequestParam(value = "productName",defaultValue = "null") String productName,
                                      @RequestParam(value = "productSort",defaultValue = "null") String productSort,
                                      @RequestParam(value = "productPrice",defaultValue = "0") BigDecimal productPrice,
                                      @RequestParam(value = "productDescript",defaultValue = "null") String productDescript,
                                      @RequestParam(value = "productStock",defaultValue = "0") Integer productStock,

                                      @RequestParam(value = "productImgPath",defaultValue = "/static/image/default.png") String productImgPath
                                      ){

        System.out.println("productId===="+productId);
        Product product=new Product(productId,productName,productSort,productPrice,productDescript,productStock,productImgPath);

        boolean b = productService.updateProduct(product);
        String msg="";

        if (b){
            msg="更新成功";
        }
        else {
            msg="更新失败";
        }
        httpServletRequest.setAttribute("msg",msg);
        return "admin/products_manager_update";

    }

    @RequestMapping("/productsDelete")
    public String getProductsDelete(
                                    @RequestParam(value = "productId",defaultValue = "-1") Integer productId){

        boolean b = productService.deleteProduct(productId);
        String msg = "?msg="+Msg.MsgUtils(b, "删除");
        return "forward:/admin/productsManager"+msg;

    }

    @RequestMapping("/productsAdd")
    public String getProductsAdd(){
        return "admin/products_manager_add";
    }

    @RequestMapping("/productsAddTo")
    public String getProductsAddTo(HttpServletRequest httpServletRequest,
                                      @RequestParam(value = "productName",defaultValue = "null") String productName,
                                   @RequestParam(value = "productSort",defaultValue = "null") String productSort,
                                   @RequestParam(value = "productPrice",defaultValue = "0") BigDecimal productPrice,
                                   @RequestParam(value = "productDescript",defaultValue = "null") String productDescript,
                                   @RequestParam(value = "productStock",defaultValue = "0") Integer productStock,

                                   @RequestParam(value = "productImgPath",defaultValue = "/static/image/default.png") String productImgPath){


        Product product=new Product(0,productName,productSort,productPrice,productDescript,productStock,productImgPath);
        int i = productService.addProduct(product);
//        System.out.println("product===="+productName);
//        System.out.println("product===="+productSort);
//        System.out.println("product===="+productPrice);
//        System.out.println("product===="+productStock);
//        System.out.println("product===="+productDescript);
//        System.out.println("product===="+productImgPath);
//        System.out.println("product===="+productName);

        log.info("i==="+i);
        //todo 文件上传功能
        String msg;
        if (i==1){
            msg="添加成功";
        }
        else {
            msg="添加失败";
        }
        httpServletRequest.setAttribute("msg",msg);

        return  "admin/products_manager_add";
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
