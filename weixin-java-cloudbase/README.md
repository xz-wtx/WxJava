## 如何使用 `WxJava` 进行小程序云开发

[云开发-一站式后端云服务](https://tencentcloudbase.github.io/)

### 一、  引入`maven`依赖


```
<dependency>
    <groupId>com.github.binarywang</groupId>
    <artifactId>weixin-java-miniapp</artifactId>
    <version>3.7.1.B</version>
</dependency>
```


### 二、  构造配置类，填入相关参数

```
    WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
    config.setAppid(...); // 微信小程序的appid
    config.setSecret(...); // 微信小程序的Secret
    config.setToken(...); // 微信小程序消息服务器配置的token,如果程序不涉及相关功能，可以忽略
    config.setAesKey(...); // 微信小程序消息服务器配置的EncodingAESKey，同上，如果不涉及，可以忽略
    config.setMsgDataFormat(...); // 消息数据格式，可以为XML或者JSON
```


### 三、  构造service类，关联上述配置
 
```
   WxMaService wxMaService= new WxMaServiceImpl();

   wxMaService.setWxMaConfig(config);
```

### 四、  根据小程序前端需要调用相应的方法：

目前 `WxJava` 已支持当前所有接口（当然如果官方后续加入新接口，则还未在最新版本中实现，会考虑在之后版本中加入），所有已支持的接口列表可以参考在线`JavaDoc`：http://binary.ac.cn/weixin-java-miniapp-javadoc/cn/binarywang/wx/miniapp/api/WxMaCloudService.html


以触发云函数接口为例，可以采用如下方式调用 `invokeCloudFunction` 方法：


```
String result = wxMaService.getCloudService().invokeCloudFunction("rcn", "login", "{}"); // 拿到result之后，可以在后续加入自己的处理逻辑代码
```


更多方法调用实例可以参考 `WxJava` 源码中的单元测试类：`cn.binarywang.wx.miniapp.api.impl.WxMaCloudServiceImplTest`

### 五、  `Spring` 框架整合：

可以参考https://github.com/binarywang/weixin-java-miniapp-demo 此项目整合 `Spring` 开发。
此项目基于 `Spring Boot` ，如果需要支持`Spring MVC`项目，适当改造即可。
