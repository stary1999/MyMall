package com.stary.mymall.order;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author stary
 * @version 1.0
 * @classname time
 * @description
 * @create 2021/10/3-15:59
 */
public class time {


    @Test
    public void testTime(){
        long  timeNew =  System.currentTimeMillis();
        System.out.println("time=="+timeNew);

        //生成时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = df.format(new Date());
        System.out.println("new time=="+date);

        //生成时间戳
        SimpleDateFormat df2 = new SimpleDateFormat("MM月dd日HH时mm分");//设置日期格式
        String date2 = df2.format(new Date());
        System.out.println("new time=="+date2);

    }
}
