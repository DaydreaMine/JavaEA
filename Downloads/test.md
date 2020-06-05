
# Table of Contents

1.  [什么是DI？](#orgf142cc7)
2.  [在Spring中注入Bean有几种方式？你认为那种方式最好， 为什么？](#org5fdb94b)
3.  [BeanFactory和ApplicationContext之间的区别是什么？](#org513de46)
4.  [什么是Spring Bean？](#orgcb14a18)
5.  [如何定义Spring Bean的作用域？](#org78cf737)
6.  [Spring Bean的生命周期是怎样的？](#org575c7bd)
7.  [Spring Boot是什么？](#org74af3dc)
8.  [列举Spring Framework所使用的设计模式](#org1d7859a)
9.  [Bean Scope Prototype如何工作？](#org05d6de8)
10. [描述在Spring MVC模型下对于一次请求的完整工作流](#org1663bef)
11. [AOP的实现原理及其优点](#org821b839)


<a id="orgf142cc7"></a>

# 什么是DI？
依赖注入，当一个对象要调用另一个对象的属性，叫做依赖，
这时候为了降低程序的耦合性，ioc容器将创建新对象的控制权从开发者手中拿过来，通过@atuowrid来创建，这叫做注入

<a id="org5fdb94b"></a>

# 在Spring中注入Bean有几种方式？你认为那种方式最好， 为什么？
1.构造方法注入 2.setter方法注入 3.借口注入
通过settter方法注入比较好，


<a id="org513de46"></a>

# BeanFactory和ApplicationContext之间的区别是什么？
ApplicationContext是beanfactory接口的扩展，spring是先生成bean工厂，然后通过bean工厂将beanfactory内部的所有bean实例化，然后applicationcontext通过getbean的方法来确认是否bean被实例化了，如果实例化成功则调用对应的bean对象，否则创建再调用。


<a id="orgcb14a18"></a>

# 什么是Spring Bean？
Spring Bean就是被spring容器通过ioc/di实例化的java对象


<a id="org78cf737"></a>

# 如何定义Spring Bean的作用域？
通过@scope的注解声明bean的作用域
1.单例模式，整个spring的生命周期中只会有一个bean只会有唯一个对象存在
2.多例模式，同时可以有多个bean存在
3.request，被request标注的bean只有在对应的request请求发来的时候才会创建bean对象
4.session，被session标注的bean，当bean实例化的时候会创建一个session对象，这个session对象会随着这个bean的消亡而结束


<a id="org575c7bd"></a>

# Spring Bean的生命周期是怎样的？
首先，spring容器会创建一个beanfactory对象，beanfacotry相当于所有bean类的集合的工厂，会将内部存贮着的bean会被实例化，然后appliciationcontext会生成context对象，context通过getbean的方法来引用相对应的bean对象，bean对象随着容器的消亡而消亡


<a id="org74af3dc"></a>

# Spring Boot是什么？
spring boot由spring发展而来，集合了诸多插件，为了减轻spring的框架


<a id="org1d7859a"></a>

# 列举Spring Framework所使用的设计模式
代理模式，单例模式，工厂模式


<a id="org05d6de8"></a>

# Bean Scope Prototype如何工作？
prototype模式：一个bean可以通过new或者@atuowried来创建多个不同的对象，这些对象不会随着容器的消亡而结束，需要设定bean的结束位置，否则不利于维护


<a id="org1663bef"></a>

# 描述在Spring MVC模型下对于一次请求的完整工作流
client发送request和response到服务器，websever通过http协议解析请求，然后将请求交个dispatchservlet，dispatch将url发送给hadlermapping，handler通过url找到对应的handler地址和拦截器，将之编译为chain发送给dispatchservlet，后者通过chain中的信息，将请求通过编排好顺序的拦截器，然后再经过apacth将参数从字符串转换为正确的格式，最后再发送给对应的handler对象处理，handler将处理好的请求通过moderandview发送给dispatch，dispatch通过其中的view置换器找到对应的view文件，然后通过view渲染，最后将回应通过websever编译发送给client


<a id="org821b839"></a>

# AOP的实现原理及其优点
aop：面向切面工程，application的开发往往会有一些方法与业务的实现无关，这时候为了方便维护与区分引入了aop
aop与所写的业务逻辑相对独立，通过设置pointcut使aop在业务逻辑的某一时间点实现，adivce就是aop在这个时间点的具体实现，又apointcut和advice组成的又称为aspect。


