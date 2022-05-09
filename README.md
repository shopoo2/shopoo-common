# 项目需求介绍
梦燃传单是一个为了取代派发纸质传单的繁琐而开发的电子传单小程序，商家可以在平台上制作自己的传单，然后设置电子传单的派发范围，派发佣金完成传单的制作。用户在平台上通过分享商家的传单来获得佣金。商家可以通过平台观察传单派发的效果，更好的推广自己的产品，避免纸质传单随街乱飞的情况。
# 项目使用的技术
1.[COLA架构](https://github.com/alibaba/COLA) - 阿里开源的DDD架构

2.Spring Boot 2.6.7

3.Spring Cloud 2021.0.2

4.Dubbo 3.0作为RPC调用

5.Nacos作为注册中心和配置中心

6.RocketMQ消息队列

7.MyBatis-Plus作为数据库操作组件

8.Spring Cloud Gateway作为服务网关

9.Oauth2作为权限认证
# 领域模型图
<img src="https://p3.toutiaoimg.com/img/tos-cn-i-qvj2lq49k0/b0046ac9ad664b919e110075c658101a~tplv-tt-shrink:640:0.image" img_width="1226" img_height="713" image_type="1" mime_type="image/png" web_uri="tos-cn-i-qvj2lq49k0/b0046ac9ad664b919e110075c658101a" class="syl-page-img" data-src="https://p3.toutiaoimg.com/img/tos-cn-i-qvj2lq49k0/b0046ac9ad664b919e110075c658101a~tplv-tt-shrink:640:0.image" style="height: auto;">

# 领域上下文映射图
<img src="https://p9.toutiaoimg.com/img/tos-cn-i-qvj2lq49k0/93ea44ea580a4136865abef0894cf6e2~tplv-tt-shrink:640:0.image" img_width="1049" img_height="819" image_type="1" mime_type="image/png" web_uri="tos-cn-i-qvj2lq49k0/93ea44ea580a4136865abef0894cf6e2" class="syl-page-img" data-src="https://p9.toutiaoimg.com/img/tos-cn-i-qvj2lq49k0/93ea44ea580a4136865abef0894cf6e2~tplv-tt-shrink:640:0.image" style="height: auto;">

# 实现功能
## 阿里云OSS对象服务
## 阿里云短信服务对接
## 微信授权登录
