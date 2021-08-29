package com.stary.mymall.utils;

/**
 * @author stary
 * @version 1.0
 * @classname Msg
 * @description
 * @create 2021/8/29-21:36
 */
public class Msg {
    public static String MsgUtils(Boolean b,String msg){
        if (b){
            return msg+"成功";
        }
        else {
            return msg+"失败";
        }
    }
}
