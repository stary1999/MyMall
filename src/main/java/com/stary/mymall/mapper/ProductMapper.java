package com.stary.mymall.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stary.mymall.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author stary
 * @since 2021-08-27
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> queryAll();
    Product queryById(Integer id);
    IPage<Product> queryPageBySort(@Param("page") Page<?> page,@Param("productSort") String productSort);
    IPage<Product> selectPage(Page<?> page);

    Integer addProduct(Product product);
    Boolean updateProduct(Product product);
    Boolean deleteProduct(Integer productId);


}
