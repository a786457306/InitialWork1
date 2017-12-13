package com.xiaozl.initialwork1.mapper;

import org.apache.ibatis.annotations.Param;

import com.xiaozl.initialwork1.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
public interface UserMapper {

    /**
     * 添加新用户
     *
     * @param user
     * @throws Exception
     */

    public void newUser(@Param("user") User user) throws Exception;

    /**
     * 删除用户（状态设为0）
     *
     * @param userId
     * @throws Exception
     */
    public void delUser(@Param("userId") Integer userId) throws Exception;

    /**
     * 修改用户信息
     *
     * @param user
     * @throws Exception
     */
    public void updateUser(@Param("user") User user) throws Exception;

    /**
     * 查询所有的用户信息
     *
     * @return
     * @throws Exception
     */
    @Select("listUser")
    public List<User> listUser() throws Exception;

    public int countByUserNameAndPassword(@Param("userName") String userName,
                                          @Param("password") String password) throws Exception;

}
