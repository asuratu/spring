package com.feng.test;

import com.feng.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author AsuraTu
 */
public class TestMybatis {
    // TODO 要优化
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 以上不用背, 知道怎么用就行
        // 以下是重点

        // 获取 SqlSession 对象
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
           // 利用动态代理技术, 获取到 UserMapper 的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 调用代理对象的方法
            System.out.println(userMapper.findUserById(3));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
