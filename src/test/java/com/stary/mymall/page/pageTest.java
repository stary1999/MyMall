package com.stary.mymall.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stary.mymall.entity.Product;
import com.stary.mymall.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname pageTest
 * @description
 * @create 2021/8/28-13:51
 */
@SpringBootTest
public class pageTest {
    @Autowired
    private IProductService productService;

    @Test
    public void testPage() {
        Page<Product> page = new Page<>(2, 2);
        IPage<Product> pageInfo = productService.selectProductPage(page);
        long pages = pageInfo.getPages();
        long current = pageInfo.getCurrent();
        long total = pageInfo.getTotal();
        List<Product> records = pageInfo.getRecords();
        System.out.println("pages==="+pages+"    current===="+current+"    total==="+total);
        System.out.println("records====="+records);

        System.out.println("pageInfo===" + pageInfo.toString());
    }

}
