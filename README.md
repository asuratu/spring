# mybatis

# 为什么要使用 spring

- 之前的项目中有一些问题
    1. 之前的项目中有一些硬编码(固定写死的代码)
        1. Servlet类创建使用Service对象
        2. Service类创建使用Dao对象
    2. 使用mybatis时, SqlSessionFactory对象的创建, SqlSession对象的创建很麻烦
    3. 耦合度高

# spring 注意点

- spring的作用
    1. bean的生命周期的管理: java对象的创建、使用、销毁等
    2. 轻量级：使用简单
    3. 容器：spring可以管理对象, 创建好对象, 放入spring容器, 容器就是用来存放对象的
    4. 组成部分：Spring Core、Spring AOP、Spring ORM、Spring DAO、Spring Context、Spring Web和 Spring Web MVC
    5.

# spring配置文件

- spring的功能大部分都要靠配置文件(xml), 配置完成
- 名字: 无限制, 但是一般有: spring.xml、spring-context.xml、applicationContext.xml、beans.xml,
  最常用的是 `applicationContext.xml`
- 位置: 一般放在 `src/main/resources` 目录下

# 创建工厂Bean

- 工厂Bean, 即创建工厂对象, 有工厂加载配置文件, 通过配置文件创建容器, 通过容器创建对象

# IOC和DI

- IOC: 全称是 Inversion of Control, 即`控制反转`, 也叫做`依赖注入`(Dependency Injection), 控制反转是一种设计思想,
  依赖注入是实现控制反转的一种方式, 控制反转的目的是为了解耦, 还有其他的方式实现控制反转, 例如: 事件驱动, 依赖查找,
  服务定位器等
- DI: 全称是 Dependency Injection, 即依赖注入: 通过构造方法、set方法、接口注入、注解注入、自动注入等方式注入对象, 其实就是属性赋值
- IOC是Spring框架的核心功能之一, 也是Spring框架的基础
