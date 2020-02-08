## 这个框架的作用
在自动测试中，一个对dubbo接口进行mock的框架

## 原理
利用dubbo的扩展点自动包装，通过EasyMockClusterWrapper将原本的rpc请求改写为http请求转发到mock服务器返回我们对应mock结果

![](img/principle.jpg)

## 使用
