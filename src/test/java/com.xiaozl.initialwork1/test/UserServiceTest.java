package com.xiaozl.initialwork1.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaozl.initialwork1.AbstractTestCase;
import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.service.UserService;

import java.util.Collections;
import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
public class UserServiceTest extends AbstractTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void newUser() throws Exception {
        User user = new User();
        user.setUserName("abc");
        user.setPassword("123456");

        userService.newUser(user);

    }

    @Test
    public void listUser() throws Exception{
        List<User> list = Collections.emptyList();
        list = userService.listUser();
        for (User user : list){
            System.out.println(user.getUserName());
        }
    }
}
