package com.feng.test;

import com.feng.mapper.UserMapper;
import com.feng.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author AsuraTu
 */
public class TestJUnitMybatis extends BaseTest {

    @Test
    public void testFindUserById() {
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

    @Test
    public void testFunc1() {
        System.out.println("测试方法1");
    }

    @Test
    public void findAllUser() {
        // 获取 SqlSession 对象
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 利用动态代理技术, 获取到 UserMapper 的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 使用插件分页
            PageHelper.startPage(2, 2);

            // 调用代理对象的方法
            List<User> allUser = userMapper.findAllUser(1000, "feng");

            // 后续获得分页信息
            PageInfo<User> userPageInfo = new PageInfo<>(allUser);

            System.out.println(userPageInfo);

            System.out.println("共计: " + allUser.size() + " 条数据");

            for (User user : allUser) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFindUserByLoginMap() {
        // 获取 SqlSession 对象
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 利用动态代理技术, 获取到 UserMapper 的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建一个 Map, 用于存放登录信息
            HashMap<String, Object> loginMap = new HashMap<>();
            loginMap.put("passport", "admin1");
            loginMap.put("password", "111");

            // 调用代理对象的方法
            List<User> allUser = userMapper.findUserByLoginMap(loginMap);
            System.out.println("共计: " + allUser.size() + " 条数据");
            for (User user : allUser) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertUser() {
        // 获取 SqlSession 对象
        // openSession() 方法默认是不自动提交事务的
        // 如果要自动提交事务, 需要传入一个 boolean 类型的参数 true, 如: openSession(true)
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 利用动态代理技术, 获取到 UserMapper 的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建一个 Map, 用于存放登录信息
            User user = new User();
            user.setNickname("feng");
            user.setPassport("admin1");
            user.setPassword("111");
            user.setBalance(1000.0);

            // 调用代理对象的方法
            boolean insertUser = userMapper.insertUser(user);
            System.out.println(insertUser);
            // 提交事务, 默认是不自动提交事务的
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdateUser() {
        // 获取 SqlSession 对象
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 利用动态代理技术, 获取到 UserMapper 的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建一个 Map, 用于存放登录信息
            User user = new User();
            user.setId(3);
            user.setNickname("feng1");
            user.setPassport("admin11");
            user.setPassword("111");
            user.setBalance(1000.0);

            // 调用代理对象的方法
            boolean updateUser = userMapper.updateUser(user);
            System.out.println(updateUser);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMap() {
        HashMap<String, Object> loginMap = new HashMap<>();
        loginMap.put("passport", "admin1");
        loginMap.put("password", "111");
        Object passport = loginMap.get("passport");
        System.out.println(passport);
    }

    @Test
    public void deleteUserByIdList() {
        // 数组 包含 26, 27
        List<Integer> idList = Arrays.asList(26, 27);

        // q: List 和 ArrayList 的区别?
        //  1. List 是接口, ArrayList 是 List 的实现类
        //  2. List 是有序的, 可以重复的, 可以存放多个 null
        //  3. ArrayList 是有序的, 可以重复的, 可以存放多个 null
        //  4. ArrayList 是线程不安全的, 效率高, 适合于单线程操作
        //  5. Vector 是线程安全的, 效率低, 适合于多线程操作
        //  6. ArrayList 底层是数组, Vector 底层是链表
        //  7. ArrayList 扩容是原容量的 1.5 倍, Vector 扩容是原容量的 2 倍

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 利用动态代理技术, 获取到 UserMapper 的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 调用代理对象的方法
            boolean result = userMapper.deleteUserByIdList(idList);
            System.out.println(result);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 测试一级缓存
    // 默认一级缓存的作用域是 SqlSession, 一级缓存是 SqlSession 级别的缓存
    @Test
    public void testOneLevelCache() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 第一次查询
            User user1 = userMapper.findUserById(4);
            System.out.println(user1);

            System.out.println("--------------------");

            user1.setNickname("feng1");
            boolean updateUser = userMapper.updateUser(user1);

            // 插入
            // 创建一个 Map, 用于存放登录信息
            User user = new User();
            user.setNickname("feng999");
            user.setPassport("admin1");
            user.setPassword("111");
            user.setBalance(1000.0);

            // 调用代理对象的方法
            boolean insertUser = userMapper.insertUser(user);
            System.out.println(insertUser);

            System.out.println(updateUser);

            // 第二次查询
            User user2 = userMapper.findUserById(4);
            System.out.println(user2);

            sqlSession.commit(); // 提交事务

            // 看控制台, 只有一条 SQL 语句
            // 说明第二次查询的时候, 没有发送 SQL 语句, 而是直接从缓存中获取的数据
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 一级缓存失效的情况
        // 1. SqlSession 关闭
        // 2. SqlSession 执行了 commit 操作
        // 3. SqlSession 执行了 update 操作
        // 4. SqlSession 执行了 delete 操作
        // 5. SqlSession 执行了 close 操作

    }

    // q: 如何修改一级缓存的作用域?
    // a: 修改 mybatis-config.xml 文件
    // q: 一级缓存的作用域有哪些
    // a: SESSION, STATEMENT
    // SESSION: 一级缓存的作用域是 SqlSession 级别的缓存, 默认值
    // STATEMENT: 一级缓存的作用域是 Statement 级别的缓存
//    <settings>
//        <setting name="localCacheScope" value="STATEMENT"/>
//    </settings>

    // 测试二级缓存
    // 二级缓存的作用域是 Mapper 级别的缓存
    @Test
    public void testTwoLevelCache() {
        try (SqlSession sqlSession1 = sqlSessionFactory.openSession()) {
            UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
            User user1 = userMapper1.findUserById(4);
            System.out.println(user1);

            // 二级缓存需要序列化
            // 在 User 类中实现 Serializable 接口
            // 序列化: 将对象转换成字节序列的过程

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cache Hit Ratio [com.feng.mapper.UserMapper]: 0.0 表示命中率是 0/1

        System.out.println("--------------------");

        try (SqlSession sqlSession2 = sqlSessionFactory.openSession()) {
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
            User user2 = userMapper2.findUserById(4);
            System.out.println(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cache Hit Ratio [com.feng.mapper.UserMapper]: 0.5 表示命中率是 1/2

        System.out.println("--------------------");

        try (SqlSession sqlSession2 = sqlSessionFactory.openSession()) {
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
            User user2 = userMapper2.findUserById(4);
            System.out.println(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cache Hit Ratio [com.feng.mapper.UserMapper]: 0.6666 表示命中率是 2/3

        System.out.println("--------------------");

        // 从控制台可以看出, 第二次查询的时候, 没有发送 SQL 语句, 而是直接从缓存中获取的数据
        // 说明二级缓存生效了

        try (SqlSession sqlSession1 = sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = sqlSession1.getMapper(UserMapper.class);

            // 创建一个 Map, 用于存放登录信息
            User user = new User();
            user.setId(4);
            user.setNickname("feng4");
            user.setPassport("admin11");
            user.setPassword("111");
            user.setBalance(1000.0);

            // 调用代理对象的方法
            boolean updateUser = userMapper.updateUser(user);
            System.out.println(updateUser);

            // 一定要记得提交事务, 除非你设置了自动提交事务 sqlSessionFactory.openSession(true)
//            sqlSession1.commit(); // 提交事务

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------------");

        try (SqlSession sqlSession2 = sqlSessionFactory.openSession()) {
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
            User user2 = userMapper2.findUserById(4);
            System.out.println(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cache Hit Ratio [com.feng.mapper.UserMapper]: 0.5  表示命中率是 2/4
    }

    // Java 中有 类似 laravel 的模型事件吗
    // 有, 叫做监听器

}
