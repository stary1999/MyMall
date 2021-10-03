package com.stary.mymall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.stary.mymall.entity.*;
import com.stary.mymall.service.CarService;
import com.stary.mymall.service.OrderService;
import com.stary.mymall.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author stary
 * @version 1.0
 * @classname ShopingController
 * @description
 * @create 2021/9/1-18:37
 */
@Controller
public class ShopingController {
    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;


    @RequestMapping("addToCart")
    @ResponseBody
    public Boolean getAddToCart(HttpServletRequest request,
                               @RequestParam(value = "productId", defaultValue = "0") String productId) {

        System.out.println("productId===" + productId);
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        //根据session获得用户Id
        String userId = String.valueOf(loginUser.getUserId());
        Boolean aBoolean = false;
        if (productId.equals("0")) {
            //返回失败
//            String msg =Msg.MsgUtils(aBoolean, "添加购物车");
            return false;

        }

        aBoolean = carService.addToCar(userId, productId);

//        String msg =  Msg.MsgUtils(aBoolean, "添加购物车");

        return aBoolean;

    }

    @RequestMapping("/getCar")
    public String getCar(HttpServletRequest request) {

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        //根据session获得用户Id
        String userId = String.valueOf(loginUser.getUserId());

        Cart cart = carService.queryToCar(userId);
        Map<Integer, CartItem> itemMap = cart.getItemMap();

//        //将itemMap的value转化为list
//        Collection<CartItem> values = itemMap.values();
//        List<Product> valueList = new ArrayList<Product>(values);


        request.setAttribute("items",itemMap);

        request.setAttribute("cart", cart);

        System.out.println(cart);
        return "mall/mall_cart";
    }

    @ResponseBody
    @RequestMapping("addToOrder")
    public Boolean addToOrder(HttpServletRequest request){

        //获取购物车数据
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        //根据session获得用户Id
        String userId = String.valueOf(loginUser.getUserId());
        Cart cart = carService.queryToCar(userId);

        //根据购物车数据构建order对象
        Order order=new Order();
        //获取时间戳
        SimpleDateFormat dfOrderId = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        SimpleDateFormat dfOrderDate = new SimpleDateFormat("MM月dd日HH时mm分");//设置日期格式

        String date1 = dfOrderId.format(new Date());
        String date2=dfOrderDate.format(new Date());
        String orderId=date1+userId;
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setOrderTime(date2);
        order.setOrderStatus("0");
        order.setOrderTotalPrice(cart.getTotalPrice());
        List<OrderItem> orderItemList=new ArrayList<>();
        for (Map.Entry<Integer, CartItem> cartItem:cart.getItemMap().entrySet()){
            Integer number = cartItem.getValue().getNumber();
            String productId =String.valueOf(cartItem.getValue().getProduct().getProductId()) ;
            BigDecimal productPrice = cartItem.getValue().getProduct().getProductPrice();

            OrderItem orderItem=new OrderItem(orderId,productId,productPrice,number);
            orderItemList.add(orderItem);


        }
        order.setOrderItemList(orderItemList);

        //添加订单
        Boolean aBoolean = orderService.addToOrder(order);


        //清空购物车
        Boolean aBoolean1 = carService.deleteToCar(userId);



        return aBoolean1&&aBoolean;
    }


    @GetMapping("/getOrder")
    public String getOrderController(){

        return "mall/mall_order";
    }
    @GetMapping("/getOrders")
    @ResponseBody
    public String getOrders(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String userId =String.valueOf(user.getUserId()) ;
        //调用
        List<Order> orders = orderService.queryOrderByUser(userId);

        JSONArray jsonArray=new JSONArray();
        jsonArray.add(orders);

        String s=jsonArray.toString();
        String newString=jsonArray.toString().substring(1,s.length()-1);
        return newString;
    }




}
