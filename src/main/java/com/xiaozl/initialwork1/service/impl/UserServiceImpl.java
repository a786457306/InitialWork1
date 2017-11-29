package com.xiaozl.initialwork1.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.mapper.UserMapper;
import com.xiaozl.initialwork1.service.UserService;
import sun.misc.BASE64Encoder;

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
        if (user == null) {
            return ;
        }

        try {
            user.setUserName(user.getUserName());
            String password = user.getPassword();
            user.setPassword(EncoderByMd5(password));
            userMapper.newUser(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String EncoderByMd5(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(password.getBytes("utf-8")));
        return newstr;
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
    public List<User> listUser() throws Exception {
        try{
            List<User> userList = Collections.emptyList();
            userList = userMapper.listUser();
            return userList;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
