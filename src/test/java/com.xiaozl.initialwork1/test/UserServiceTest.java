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
        user.setUserName("zhangzw");
        user.setPassword("qazzw3263392-");
        user.setState(1);

        userService.newUser(user);
    }

    @Test
    public void delUser() throws Exception {
        userService.delUser(1);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUserName("admin");
        user.setPassword("admin");
        user.setState(1);
        userService.updateUser(user);
    }

    @Test
    public void listUser() throws Exception{
        List<User> list = Collections.emptyList();
        list = userService.listUser();
        for (User user : list){
            System.out.println(user.getId());
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
            System.out.println(user.getState());
        }
    }
}
