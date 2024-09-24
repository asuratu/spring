package com.feng.dao.impl;

import com.feng.dao.UserDao;
import com.feng.model.User;

/**
 * @author AsuraTu
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User getUserById(Integer id) {
        System.out.println("数据访问层: UserDaoImpl.getUserById");
        return null;
    }

}
