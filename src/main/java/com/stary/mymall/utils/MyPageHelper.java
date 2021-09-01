package com.stary.mymall.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stary.mymall.entity.Product;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author stary
 * @version 1.0
 * @classname MyPageHelper
 * @description
 * @create 2021/8/28-15:26
 */
@ToString
@Data
public class MyPageHelper {

    //原page参数
    //当前页码
    private Long current;
    //总记录数
    private Long total;
    //总页数
    private Long pages;
    //返回值
    private List<?> records;
    //新增参数
    //前一页
    private Long previous;
    //后一页
    private Long next;
    //是否存在前一页
    private Boolean isPrevious;
    //是否存在后一页
    private Boolean isNext;
    //分类
    private String sort;

    public  MyPageHelper(IPage<?> pageInfo,String sort){
        this.current=pageInfo.getCurrent();
        this.pages=pageInfo.getPages();
        this.total=pageInfo.getTotal();
        this.records=pageInfo.getRecords();
        this.sort=sort;
        if (this.current>1){
            this.previous=this.current-1;
            this.isPrevious=true;
        }
        else {
            this.previous=1L;
            this.isPrevious=false;
        }
        if (this.current<this.pages){
            this.next=this.current+1;
            this.isNext=true;
        }
        else {
            this.next=pages;
            this.isNext=false;
        }

    }




}
