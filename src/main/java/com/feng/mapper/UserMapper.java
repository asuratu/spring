package com.feng.mapper;

import com.feng.model.User;
import com.feng.model.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author asura
 */
public interface UserMapper {
    // Mapper 文件夹就是类似于 Dao 层的东西

    User findUserById(int id);

    List<User> findAllUser(@Param("balance") double balance, @Param("nickname") String nickname);

    List<User> findUserByLoginMap(HashMap<String, Object> map);

    boolean updateUser(User user);

    boolean insertUser(User user);

    UserVO findUserWithGoodsById(int id);

    boolean deleteUserByIdList(List<Integer> idList);
}
