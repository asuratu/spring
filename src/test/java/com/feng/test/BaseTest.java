package com.feng.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author AsuraTu
 */
public class BaseTest {

    SqlSessionFactory sqlSessionFactory = null;

    // BeforeEach 注解表示在每个测试方法执行之前都会执行一次
    @BeforeEach
    public void init() throws IOException {
        System.out.println("准备工作");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @AfterEach // AfterEach 注解表示在每个测试方法执行之后都会执行一次
    public void after() {
        System.out.println("收尾工作");
    }

}
