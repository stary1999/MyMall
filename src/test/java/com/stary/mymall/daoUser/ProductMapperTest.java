package com.stary.mymall.daoUser;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stary.mymall.entity.Product;
import com.stary.mymall.mapper.ProductMapper;
import com.stary.mymall.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname ProductMapperTest
 * @description
 * @create 2021/8/27-19:18
 */
@Slf4j
@SpringBootTest
public class ProductMapperTest {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void test() {
        Product product = productMapper.queryById(2);
        System.out.println("product===" + product);
    }

    @Test
    public void MapperTest(){
        List<Product> products = productMapper.queryAll();
        for (Product p:products){
            System.out.println(p);
        }
        Product product = productMapper.queryById(2);
        System.out.println("prodect=="+product);
    }
    @Test void addTest(){
        BigDecimal price=new BigDecimal(50);
        Product product=new Product(0,"茶壶","百货",price,
                "来一杯tea吧",50,"/static/image/default.png");
        Integer integer = productMapper.addProduct(product);
        System.out.println("inte========"+integer);
    }
    @Test
    void updateTest(){
        BigDecimal price=new BigDecimal(50);
        Product product=new Product(7,"茶壶","百货",price,
                "来一杯tea吧",50,"/static/image/default.png");
        Boolean aBoolean = productMapper.updateProduct(product);
        System.out.println("=====boolean===="+aBoolean);
    }
    @Test
    void queryPageBySortTest(){
        String sort="数码";
        Page<Product> page=new Page<>(1,4);
        IPage<Product> productIPage = productMapper.queryPageBySort(page, sort);
        System.out.println("prodctIpage===="+productIPage.getRecords().toString());
        System.out.println("prodctIpage===="+productIPage.getPages());
        System.out.println("prodctIpage===="+productIPage.getTotal());
    }

}
