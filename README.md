# 工程简介
本项目是在上一版书城项目的基础上，进一步重构，上一个项目地址：https://github.com/stary1999/JavaWebBookCity

本项目基于SpringBoot2和thymeleaf的Web开发，对旧的Web商城项目的重构和完善，独立开发和设计了基础页面。项目分为前台用户模块和后台管理模块，前台包括了商品展示，商品购买，用户注册、登录，等功能。后台管理模块包括商品管理、用户管理、订单管理、管理员管理四个模块，实现包括增删改查、以及权限管理等功能。

* 项目仓库：https://github.com/stary1999/MyMall
* 文档：https://stary1999.github.io/2021/08/26/javaWeb2/

重构：

* 重构后台管理系统
* 重新设计界面
* 重新设计数据表
* 更新技术框架
* ……

由于此次独立程度较高，目前功能缺失较大，等待进一步实现。

## 环境

* idea2021
* MySQL8.0
* Maven3.8.1

## 技术栈

* SpringBoot作为后端开发，负责处理业务逻辑和视图分发。
* MyBatis Plus作为数据库框架，处理数据库相关操作，MySQL存储数据表信息。
* thymeleaf作为前端模板引擎，使用Bootstrap进行页面开发。
* ……

# 设计

## 1.1版本
2021-10-04
完善订单系统

添加Vue技术

完善后台基础展示

### 下一步计划

补充逻辑结构

引入专业的权限认证

完善后台管理系统，各级权限管理

引入消息队列，实现高并发

实现事务

前端展示优化

重构，将代码改为RESTFul形式，实现完整的前后端分离。

### 问题与解决

1. json多了一重括号，前端无法处理，后端手动去除

2. vue的使用，事件绑定，仍需学习。

3. 订单项的设计，两个表的拆分与整个成一个完整的order对象。

4. 前后端分离式程序设计。




## 1.0版本
2021-09-04
初步整理了现阶段的工作成果

### UI部分

之前的自己做的UI太丑
后面采用了页面模板网站中的一个后台管理模板作为网站基准模板：http://www.templatesy.com

因为之前在UI上面花费了大量时间，还达不到自己想要的效果，为了提高工作效率，在UI上使用了模板。
并根据模板进行修改，以达到符合功能的需求。

#### 结构

主体分为以下几个部分：

* admin作为后台管理页面的集合，
* mall作为商城基础页面（首页、用户登录、注册、购物车、订单等页面）
* 抽取出来的公共页面文件夹。
* 静态资源static

#### 备注

在UI部分，有几个需要注意的点

* 在公共页面抽取后，每个页面的获取，需要从MVC控制器获取，否则，将会出现页面无法响应的问题。
* js脚本的使用，有些时候，js脚本在head部分，但是jQuery在body后面，会导致$(function(){……})失效，如果遇到类似的问题，可以先从F12检查，定位错误原因，大概率是jQuery导致的。
* ajax请求的一些规范，以及function()传值问题，js中控制标签元素属性等。

### 后端

#### 数据库设计

product表

```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_sort` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` decimal(10, 2) NULL DEFAULT NULL,
  `product_descript` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_stock` int NULL DEFAULT NULL,
  `product_img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

user表

```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_admin` int NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

```

购物车使用Redis的hash表实现

目前订单表尚在完善

数据库框架采用MyBatis Plus,利用官方提供的代码生成器，可以快速生成代码，可以简单使用，但是具体SQL语句，还是建议自己手动写。



#### 权限控制

使用过滤器实现权限控制

注意过滤器可能会拦截一些必要的请求，需要对相关请求进行放行，例如，注册页面中使用了ajax来实现用户名和邮箱校验，也需要对其放行。

#### 其他

客户端登录，采用cookie自动填写，当客户端勾选记住后，登录成功会发送cookie到浏览器端，在下次登录时自动填写（手动确认登录）。

浏览器端采用session识别用户状态，从session中获取用户信息，当用户登出时，移除session数据。





具体逻辑代码参见src，
结构说明参见文档：https://stary1999.github.io/2021/08/26/javaWeb2/