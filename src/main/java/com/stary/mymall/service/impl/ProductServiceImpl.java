package com.stary.mymall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.stary.mymall.entity.Product;
import com.stary.mymall.mapper.ProductMapper;
import com.stary.mymall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stary
 * @since 2021-08-27
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    ProductMapper productMapper;

    public IPage<Product> selectProductPage(Page<Product> page) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return productMapper.selectPageVo(page);
    }
    public Product selectProductById(Integer id){
        return productMapper.queryById(id);
    }
    public int addProduct(Product product){
        return productMapper.addProduct(product);
    }
    public boolean updateProduct(Product product){
        return productMapper.updateProduct(product);
    }
    public boolean deleteProduct(Integer productId){
        return productMapper.deleteProduct(productId);
    }




}
