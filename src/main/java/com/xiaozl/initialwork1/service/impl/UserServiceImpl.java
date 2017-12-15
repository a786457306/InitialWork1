package com.xiaozl.initialwork1.service.impl;

import com.xiaozl.initialwork1.util.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.mapper.UserMapper;
import com.xiaozl.initialwork1.service.UserService;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void newUser(User user) throws Exception {
        MD5Util md5Util = new MD5Util();
        if (user == null) {
            return ;
        }
        try {
            user.setUserName(user.getUserName());
            String password = user.getPassword();
            user.setPassword(md5Util.EncoderByMd5(password));
            user.setState(user.getState());
            userMapper.newUser(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delUser(Integer userId) throws Exception {
        try {
            userMapper.delUser(userId);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) throws Exception {
        MD5Util md5Util = new MD5Util();
        if (user == null)
            return;
        try {
            user.setId(user.getId());
            user.setUserName(user.getUserName());
            String password = user.getPassword();
            user.setPassword(md5Util.EncoderByMd5(password));
            userMapper.updateUser(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<User> listUser() throws Exception {
        try{
            List<User> userList = Collections.emptyList();
            userList = userMapper.listUser();
            return userList;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean checkLogin(User user) throws Exception {
        if (user == null) {
            return false;
        }
        try {
            return userMapper.countByUserNameAndPassword(user.getUserName(), user.getPassword()) > 0 ? true : false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User queryUserById(Integer userId) throws Exception {
        User user = userMapper.queryUserById(userId);
        System.out.println(user.getUserName());
        return userMapper.queryUserById(userId);
    }
}
