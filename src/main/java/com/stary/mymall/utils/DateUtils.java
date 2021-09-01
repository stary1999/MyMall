package com.stary.mymall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author stary
 * @version 1.0
 * @classname DateUtils
 * @description
 * @create 2021/9/1-10:26
 */



public class DateUtils {
    // 日期转字符串，返回指定的格式
    public static String dateToString(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
}