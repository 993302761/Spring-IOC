# Spring-IOC

* ##主要实现：

1.定义bean相关的pojo类(pojo)

2.定义注册表相关类(registry)

3.定义解析器相关类(parser)

4.IOC容器相关类

* ##使用到的设计模式：

工厂模式+配置文件

单例模式，IOC管理的bean对象都是单例的

模板方法模式，AbstractApplicationContext中的finishBeanInitialization方法调用了子类的getBean方法，因为getBean的实现和环境息息相关

迭代器模式，MutablePropertyValue类中

真正的spring框架用到的设计模式更多，比如AOP用到了代理模式。