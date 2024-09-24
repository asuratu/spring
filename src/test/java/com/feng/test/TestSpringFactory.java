package com.feng.test;

import com.feng.di.TestModel;
import com.feng.di.TestModel2;
import com.feng.model.Goods;
import com.feng.service.GoodsService;
import com.feng.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author AsuraTu
 */
public class TestSpringFactory {

    @Test
    public void test() {
        // 配置文件路径
        String path = "applicationContext.xml";

        // 通过配置文件路径获取 Spring 工厂
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        // 通过工厂获取对象, 拿到的是 Object 类型, 需要强转
        // 强转可能会出现类型转换异常
//        Goods goods = (Goods) context.getBean("goods");

        // 也可以通过类型获取对象, 但是如果有多个同类型的对象, 会报错
        Goods goods = context.getBean("goods", Goods.class);

        // 调用对象方法
        goods.test();
        System.out.println(goods);
    }

    @Test
    public void testIOC() {
        // 配置文件路径
        String path = "applicationContext.xml";

        // 通过配置文件路径获取 Spring 工厂
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        // 获得业务层对象
        // UserService 是接口
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService.findUserById(1));
    }

    @Test
    public void testIOC2() {
        // 配置文件路径
        String path = "applicationContext.xml";

        // 通过配置文件路径获取 Spring 工厂
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        // 获得业务层对象
        // GoodsService 是接口
        GoodsService goodsService = context.getBean("goodsService", GoodsService.class);

        System.out.println(goodsService.findGoodsById(1));
    }

    @Test
    public void testDI() {
        // 配置文件路径
        String path = "applicationContext.xml";

        // 通过配置文件路径获取 Spring 工厂
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        // 获得业务层对象
        TestModel testModel = context.getBean("testModel", TestModel.class);

        // 调用业务层方法
        testModel.printTime();

        System.out.println(testModel);
    }

    @Test
    public void testDI2() {
        // 配置文件路径
        String path = "applicationContext.xml";

        // 通过配置文件路径获取 Spring 工厂
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        // 获得业务层对象
        TestModel2 testModel2 = context.getBean("testModel2", TestModel2.class);

        System.out.println(testModel2);
    }
}
