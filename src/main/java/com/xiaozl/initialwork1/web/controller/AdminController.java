package com.xiaozl.initialwork1.web.controller;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
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
        return "/admin/listUser";
    }




}
