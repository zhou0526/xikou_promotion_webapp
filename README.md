# WebApp网关服务编排
 
 之所以在rpc服务层的基础之上增加一层web网关服务编排层出于三个方面的考虑:
   1. rpc在跨语言调用方面需要额外的依赖,目前业务系统中前端交互设备比较繁杂,有APP(IOS/安卓),H5,微信小程序和PC浏览器，
      为了统一接口交互和减少开发工作量故架设一层通用的webApp.
   2. 考虑到后续接口的兼容性和版本升级,通过架设一层通用的webApp来屏蔽底层rpc的快速变化和重构.
   3. 可以将复杂多变的服务编排逻辑控制在webApp层,使得底层rpc服务更关注于业务,更简单,更通用化.   

#### 介绍

营销管理系统

服务网关按业务模块分为多个子系统.
不同子系统之间分别建立独立的网关.


#### 软件架构

软件架构说明 
  1. spring restful(github全站都采用rest方式实践,取得很不错的效果)
     1.1 系统采用流行的restful面向资源服务方式向外界提供服务
     1.2 controller层所有对外接口需要根据业务需要分别提供GET(读取),POST(新建,更新,删除)接口
     1.3 接口url映射需要按照rest规范定义,后台开发人员在定义接口URL时需要与业务,前端开发和APP开发人员共同协商
     1.4 对用户CRUD的url进行示例:
         GET  用于读取
         POST 用于新建,更新,删除
         注意: 
           接口URI全部用小写,单词间使用下划线'_'进行隔离区分
           URI层级最多为三层,第一层是业务名,如user,account等.
           示例：
           GET  /user/users  获取用户模块下用户列表
           GET  /user/users?page=1&limit=10  分页获取用户模块下用户列表
           GET  /user/wx_user_info 获取用户模块下微信用户信息
           GET  /user/ID    根据用户ID获取单个用户信息
           POST /user/create 新建一个用户
           POST /user/update/ID 修改某个用户信息 
           POST /user/delete/ID  删除某个用户信息
           GET  /account/ID      根据账户Id获取账户信息
           POST /account/update/ID 修改某个账户信息
  2. motan client
  3. http协议+json
  4. 正由于系统采用标准的http基于rest格式对外提供服务,故在数据做新建,更新和删除操作时,需要格外注意接口鉴权和安全问题

软件工程目录说明
src
  -main
  --java
    --- common         系统通用组件层
    --- configuration  全局系统配置
    --- constant       全局系统常量(需要根据业务进行分包)
    --- controller     接口URI分发(需要根据业务进行分包)
    --- exception      全局系统异常处理器
    --- filter         全局系统过滤
    --- listener       全局系统监听器
    --- mq             系统消息组件
    --- trace          系统通用日志组件
    --- utils          系统常用工具包
    --- vo             网关层数据模型与视图(与前端进行数据交互)
    
#### 安装教程

1. maven编译: mvn clean install
2. copy项目跟目录target下的的xikou-member-webapp.war包
3. 将xikou-member-webapp.war部署到应用服务器tomcat根目录的webapps文件夹下
4. 启动tomcat即可

#### 使用说明

1. 下载项目工程后,请先熟悉src/main/java目录下的所有文件夹
2. 然后对照上文软件工程目录说明熟悉某一层文件夹所标注的说明和用途
3. 熟悉项目工程下src/main/resources的所有配置文件,网关服务一共包含四个层次的配置,即对应四个编码环境.
   本地环境: local
   开发环境: dev
   测试环境: test
   生产环境: prod




