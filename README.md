# SchoolShopSpringBoot
backend shop management, frontend user system and super admin system. Using SpringBoot, MySQL, Redis as cache, Thumbnails, quartz scheduled task etc.

# Introduction

注意：这是一个练习项目，非正式商业项目，用于我自己练习Springboot快速开发web应用。  
校园店铺项目主要分为店家管理功能模块, 前端用户展示功能模块以及超级管理员系统模块。店家微信公众号登录后端，添加店铺并进行店铺管理(店铺和商品CRUD，积分，销售情况查询等)。前端用户通过微信公众号进入首页，浏览店铺以及店铺商品，购买商品后可由店家扫码以此累计在该店铺的积分，积分可用来兑换该店铺的积分奖品。此项目无支付相关功能，通过积分增加用户粘性。具有超级管理员权限的账号可以登录超级管理员模块对区域，头条，店铺类别列表等全局信息进行维护，同时可以对店铺和用户进行管理。微信登录后可绑定本地账号，创建用户名以及密码，之后可通过本地账号登录。  


## Backend shop management system
<img width="800" height="500" src="GITHUBO2OSB/backend.png"/>

## Frontend user system
<img width="800" height="500" src="GITHUBO2OSB/frontend.png"/>

## Superadmin system
<img width="800" height="500" src="GITHUBO2OSB/superadminsystem.png"/>

# Environment
  * IDE: IDEA
  * maven 3.6.3
  * JDK 10
  * Springboot 2.3.1.RELEASE
  * mybatis-spring 2.1.3
  * mysql 8.0.19
  * redis 5.0.7
  * other dependencies include quartz, fastjson, commons-fileupload, kaptcha, thumbnailtor etc. Please check the pom.xml file 
  
# Techs used
  * Spring IOC/AOP
     * interceptors 实现登录和店铺操作权限拦截
     * 使用javaConfig配置spring容器
     * 声明式事务注解
  * Mysql 开启主从库实现读写分离，通过crontable实现数据库定期备份
  * Redis充当缓存中间件
  * 图片开源工具 Thumbnailator 处理图片流，添加水印
  * 验证码组件Kaptcha
  * Schedulered tasks framework Quartz 定期任务执行，实现每日统计商品销量，前端使用Echart显示柱状图
  * 前端使用SUIMobile组件快速搭建页面，html与javascript实现动态写入内容，使用ajax与后端交互信息
  * 访问微信测试号接口并回调至后端controller，获取用户信息相关url参数，以此完成微信用户登录以及二维码相关的任务
  
# Shop management
**登录**   
本地登录页面，根据url参数usertype的值判断跳转到前端首页还是店铺管理页，usertype等于1跳转至前端首页，2则跳转到店铺管理页
localhost:8080/o2o/local/login?usertype=1  
<img width="500" height="600" src="GITHUBO2OSB/login.png"/>  
**该用户名下店铺**  
<img width="500" height="600" src="GITHUBO2OSB/shoplist.png"/>  
<img width="500" height="250" src="GITHUBO2OSB/shoplist2.png"/>  
**店铺管理页面**  
<img width="500" height="600" src="GITHUBO2OSB/shopmanage.png"/>  
**连续七天本店铺个商品的销售情况和销售记录**  
<img width="800" height="600" src="GITHUBO2OSB/purchaseRecords.png"/>  
**编辑或者添加店铺**  
<img width="500" height="600" src="GITHUBO2OSB/editoraddshop.png"/>  
**商品管理**  
<img width="500" height="600" src="GITHUBO2OSB/productmanage.png"/>  
**商品分类管理**  
<img width="500" height="600" src="GITHUBO2OSB/productcate.png"/>  
**本店铺奖品管理**  
<img width="500" height="600" src="GITHUBO2OSB/awardmanage.png"/>  
**用户在商店当前积分情况**  
<img width="500" height="600" src="GITHUBO2OSB/userpointsrecord.png"/>  
**给店员授权，使得他们可以给消费者积分或者兑换奖品给消费者**  
<img width="500" height="600" src="GITHUBO2OSB/authstaff.png"/>  

# Frontend system
**首页**  
<img width="500" height="600" src="GITHUBO2OSB/index.png"/>  
**侧边栏**  
<img width="500" height="600" src="GITHUBO2OSB/mysystem.png"/>  
**店铺列表**  
<img width="500" height="600" src="GITHUBO2OSB/frontshoplist.png"/>  
**店铺详情以及该店铺下商品列表**  
<img width="500" height="600" src="GITHUBO2OSB/frontshopdetail.png"/>  
<img width="500" height="600" src="GITHUBO2OSB/frontshopdetail2.png"/>  
**商品详情及其二维码，扫码可以为自己积分**  
<img width="500" height="600" src="GITHUBO2OSB/productdetail.png"/>  
<img width="500" height="600" src="GITHUBO2OSB/peoductdetail2.png"/>  
**我的奖品，分为已领取和未领取，未领取点击后获得二维码，店员扫描即可领取，同时消费者在该店铺的积分情况会被修改**  
<img width="500" height="600" src="GITHUBO2OSB/myaward.png"/>  
**我的积分**  
<img width="500" height="600" src="GITHUBO2OSB/mypoint.png"/>  
**我的消费记录**  
<img width="500" height="600" src="GITHUBO2OSB/mypurchrecord.png"/>  

# Superadmin system
<img width="1500" height="900" src="GITHUBO2OSB/superadmin.png"/>  
