package com.stary.mymall.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author stary
 * @version 1.0
 * @classname backJson
 * @description
 * @create 2021/8/25-9:29
 */
public class BackJson {


    public static void backJson(HttpServletResponse response, Map map) throws IOException {
        JSONObject jsonObject = new JSONObject();

//        map.put("phone","1223456");
//        map.put("status","ok");
        jsonObject.put("info", map);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(jsonObject.toJSONString());

    }
}