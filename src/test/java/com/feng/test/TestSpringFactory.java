package com.feng.test;

import com.feng.model.Goods;
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
}
