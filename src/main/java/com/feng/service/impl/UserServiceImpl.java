package com.feng.service.impl;

import com.feng.dao.UserDao;
import com.feng.model.User;
import com.feng.service.UserService;

/**
 * @author AsuraTu
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    // Service 层依赖于 Dao 层, 通过 set 方法注入, 这就是依赖注入 (DI), 即属性赋值
    // 依赖注入的方式有多种: 1. 构造方法注入 2. set 方法注入 3. 接口注入 4. 注解注入 5. 静态工厂注入 6. 实例工厂注入 7. 自动装配

    // 通过 set 方法注入 (常用)
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUserById(Integer id) {
        System.out.println("业务层: UserServiceImpl.findUserById");

        // 调用数据访问层方法
        System.out.println(userDao.getUserById(id));

        return null;
    }
}
