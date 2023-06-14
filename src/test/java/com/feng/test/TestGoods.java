package com.feng.test;

import com.feng.mapper.GoodsMapper;
import com.feng.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @author AsuraTu
 */
public class TestGoods extends BaseTest {

    @Test
    public void testFindUserById() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 利用动态代理技术, 获取到 UserMapper 的代理对象
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);

            // 调用代理对象的方法
            System.out.println(mapper.findGoodsById(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findGoodsWithUserById() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 利用动态代理技术, 获取到 UserMapper 的代理对象
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);

            // 调用代理对象的方法
            System.out.println(mapper.findGoodsWithUserById(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findUserWithOrders() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            // 调用代理对象的方法
            System.out.println(mapper.findUserWithGoodsById(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
