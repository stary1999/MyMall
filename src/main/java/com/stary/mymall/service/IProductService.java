package com.stary.mymall.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stary.mymall.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stary
 * @since 2021-08-27
 */
public interface IProductService extends IService<Product> {

    public IPage<Product> selectProductPage(Page<Product> page);
    public int addProduct(Product product);
    public Product selectProductById(Integer id);
    public boolean updateProduct(Product product);
}
