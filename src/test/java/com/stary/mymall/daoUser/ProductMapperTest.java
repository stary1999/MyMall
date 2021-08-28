package com.stary.mymall.daoUser;

import com.stary.mymall.entity.Product;
import com.stary.mymall.mapper.ProductMapper;
import com.stary.mymall.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
