package com.xiaozl.initialwork1.web.controller;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.service.UserService;
import com.xiaozl.initialwork1.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * AdminController
 *
 * @author Daydreamer
 * @date 2017/12/13 10:35
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    private UserService userService;
    /**
     * 去用户列表页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public String toList(Model model){
        List<User> userList = new ArrayList<User>();
        try {
            userList = userService.listUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userList",userList);
        return "admin/listUser";
    }

    /**
     * 去用户信息修改页
     *
     * @param userId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateUser", method = RequestMethod.GET)
    public String toUpdateUser(Integer userId, Model model) throws Exception {
        User user = userService.queryUserById(userId);
        //把用户id，name，password放到页面，方便下个方法获取
        model.addAttribute("userId", userId);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("password", user.getPassword());
        return "admin/updateUser";
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public String updateUser(User user, Model model,
                             @RequestParam("userId") Integer userId,
                             @RequestParam("userName") String userName,
                             @RequestParam("password") String password) throws Exception {
        try {
            user.setId(userId);
            user.setUserName(userName);
            user.setPassword(password);
            userService.updateUser(user);
            List<User> userList = userService.listUser();
            model.addAttribute(userList);
            return "admin/listUser";
        }catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/updateUser";
        }
    }

    /**
     * 删除用户
     *
     * @param userId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "delUser", method = RequestMethod.GET)
    public String delUser(Integer userId, Model model) throws Exception {
        userService.delUser(userId);
        List<User> userList = userService.listUser();
        model.addAttribute(userList);
        return "admin/listUser";
    }

}
