package com.stary.mymall.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author stary
 * @version 1.0
 * @classname Admin
 * @description
 * @create 2021/8/24-18:23
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/")
    public String getIndex(){
        return "admin/admin_index";
    }

    @RequestMapping("/index")
    public String getAdminIndex(){
        return "admin/admin_index";
    }

    @RequestMapping("/login")
    public String getAdminLogin(){
        return "admin/admin_login";
    }

    @RequestMapping("/commons")
    public String getCommons(){
        return "admin/commons";
    }
    @RequestMapping("/base")
    public String getBase(){
        return "admin/base";
    }

//    @PostMapping(value = "/admin/login")
//    public ModelAndView login(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        @RequestParam(defaultValue =  "no") String remember,
//                              HttpServletResponse httpResponse,
//                              HttpServletRequest httpRequest,
//                              ModelAndView modelAndView) throws IOException {
//
//
//
//        modelAndView.setViewName("admin/admin_Index");
//        return modelAndView;
////
//
//        //验证cookie todo
//        //如果存在cookie，表示已经登录了。直接返回页面到首页。
//        Cookie[] cookies = httpRequest.getCookies();
//        if (cookies!=null){
//            Map map=new HashMap();
//
//            for (Cookie cookie : cookies) {
//                String name = cookie.getName();
//                String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
//                map.put(name, value);
//            }
//            modelAndView.addObject("CookiesMap",map);
//            modelAndView.addObject("loginBoolean","true");
//            modelAndView.setViewName("admin/admin_Index");
//            return modelAndView;
//        }
//        //判断是否登录
//        //TODO
//
//
//        System.out.println("userName="+username);
//        System.out.println("password="+password);
//        System.out.println("remember="+remember);
//
//        //todo 验证账号密码
//        if(username.equals("aa@aa.aa")&&password.equals("aa") ){
//            modelAndView.addObject("adminId","001");
//            modelAndView.addObject("adminName",username);
//
//            if(remember.equals("remember-me")){
//                //todo 生成cookie
//                //创建登录用户名Cookie
//                Cookie cook_name=new Cookie("username",username);
//                //创建登录用户密码Cookie
//                Cookie cook_pwd=new Cookie("password",password);
//                //设置过期时间为10秒
//                cook_name.setMaxAge(60*60*24);
//                cook_pwd.setMaxAge(60*60*24);
//                //将Cookie写入客户端
//                httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//                httpResponse.addCookie(cook_name);
//                httpResponse.addCookie(cook_pwd);
//
//            }
//
//            modelAndView.setViewName("admin/admin_Index");
//            return modelAndView;
//        }
//        else {
//            modelAndView.addObject("msg","账号或密码错误，请重试");
//
//            modelAndView.setViewName("forward:/admin");
//
//            return modelAndView;
//        }
//    }


}

//@RestController
//public class ParameterTestController {
//
//
//    //  car/2/owner/zhangsan
//    @GetMapping("/car/{id}/owner/{username}")
//    public Map<String,Object> getCar(@PathVariable("id") Integer id,
//                                     @PathVariable("username") String name,
//                                     @PathVariable Map<String,String> pv,
//                                     @RequestHeader("User-Agent") String userAgent,
//                                     @RequestHeader Map<String,String> header,
//                                     @RequestParam("age") Integer age,
//                                     @RequestParam("inters") List<String> inters,
//                                     @RequestParam Map<String,String> params,
//                                     @CookieValue("_ga") String _ga,
//                                     @CookieValue("_ga") Cookie cookie){
//
//
//        Map<String,Object> map = new HashMap<>();
//
////        map.put("id",id);
////        map.put("name",name);
////        map.put("pv",pv);
////        map.put("userAgent",userAgent);
////        map.put("headers",header);
//        map.put("age",age);
//        map.put("inters",inters);
//        map.put("params",params);
//        map.put("_ga",_ga);
//        System.out.println(cookie.getName()+"===>"+cookie.getValue());
//        return map;
//    }
