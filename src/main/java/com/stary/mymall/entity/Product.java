package com.stary.mymall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author stary
 * @since 2021-08-27
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    private String productName;

    private String productSort;

    private BigDecimal productPrice;

    private String productDescript;

    private Integer productStock;

    private String productImgPath;

    public Product(Integer productId, String productName, String productSort, BigDecimal productPrice, String productDescript, Integer productStock, String productImgPath) {
        this.productId = productId;
        this.productName = productName;
        this.productSort = productSort;
        this.productPrice = productPrice;
        this.productDescript = productDescript;
        this.productStock = productStock;
        this.productImgPath = productImgPath;
    }
}
