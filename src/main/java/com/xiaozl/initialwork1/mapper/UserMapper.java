package com.xiaozl.initialwork1.mapper;

import com.xiaozl.initialwork1.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
public interface UserMapper {

    public void newUser(@Param("user") User user) throws Exception;

    public void delUser(@Param("userId") Integer userId) throws Exception;

    public void updateUser(@Param("user") User user) throws Exception;

    public List<User> listUser() throws Exception;

    public User queryUserById(@Param("userId") Integer userId) throws Exception;

    public int countByUserNameAndPassword(@Param("userName") String userName,
                                          @Param("password") String password) throws Exception;
}
