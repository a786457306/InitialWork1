package com.xiaozl.initialwork1.service;

import com.xiaozl.initialwork1.entity.User;

import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
public interface UserService {

    /**
     * 新建用户
     *
     * @param user
     * @throws Exception
     */
    public void newUser(User user) throws Exception;

    /**
     * 删除用户（用户状态设为0）
     *
     * @param userId
     * @throws Exception
     */
    public void delUser(Integer userId) throws Exception;

    /**
     * 修改用户信息
     *
     * @param user
     * @throws Exception
     */
    public void updateUser(User user) throws Exception;

    /**
     * 查询所有用户的信息
     *
     * @return
     * @throws Exception
     */
    public List<User> listUser() throws Exception;

    /**
     * 根据用户id查询用户
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public User queryUserById(Integer userId) throws Exception;

    /**
     *检查用户是否成功登录
     *
     * @param user
     * @return
     * @throws Exception
     */
    public boolean checkLogin(User user) throws Exception;

    /**
     * 查询用户数量
     *
     * @return
     * @throws Exception
     */
    public int countUser() throws Exception;
}
