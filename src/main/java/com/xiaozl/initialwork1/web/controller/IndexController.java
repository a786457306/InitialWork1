package com.xiaozl.initialwork1.web.controller;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.service.UserService;
import com.xiaozl.initialwork1.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
@Controller
@RequestMapping(value = "")
public class IndexController {

    @Resource
    private UserService userService;

    /**
     * 去欢迎页
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String toIndex(){
        return "index";
    }

    /**
     * 去登录页
     *
     * @param request
     * @return
     */
    @RequestMapping(value = {"", "/", "login"}, method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request)
    {
        //If session have attribute "user", jump to index page, else jump to login page.
        if (request.getSession().getAttribute("user") != null){
            return "index";
        }
        else {
            return "login";
        }
    }

    /**
     * 用户登录
     *
     * @param user
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) throws Exception{
        MD5Util md5Util = new MD5Util();
        try {
            user.setPassword(md5Util.EncoderByMd5(user.getPassword()));
            //If pass, set attribute to session, then redirect to index page.
            if (userService.checkLogin(user)) {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("userName", user.getUserName());
                return "index";
            }
            //If not pass, send error attribute.
            else{
                model.addAttribute("login_err", "登录失败!");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

    /**
     * 去注册页
     *
     * @return
     */
    @RequestMapping(value = "signIn", method = RequestMethod.GET)
    public String toSignIn()
    {
            return "signIn";
    }

    /**
     * 用户注册
     *
     * @param user
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public String signIn(User user, Model model, HttpServletRequest request) throws Exception{
        MD5Util md5Util = new MD5Util();
        try{
            userService.newUser(user);
            model.addAttribute("userName", user.getUserName());
            model.addAttribute("password", md5Util.EncoderByMd5(user.getPassword()));
            request.getSession().setAttribute("user", user);
            return "login";//注册成功返回登录页
        }catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "signIn";//出错的话重新注册
        }
    }


}