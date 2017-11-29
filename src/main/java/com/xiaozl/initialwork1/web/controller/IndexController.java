package com.xiaozl.initialwork1.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.service.UserService;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
@Controller
@RequestMapping(value = "")
public class IndexController {

    @Resource
    private UserService userService;

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

    @RequestMapping(value = "signIn", method = RequestMethod.GET)
    public String toSignIn()
    {
            return "signIn";
    }

    //Sign in
    @RequestMapping(value = "signIn",method = RequestMethod.POST)
    public String signIn(User user, Model model, HttpServletRequest request) throws Exception{
        try{
            userService.newUser(user);
            model.addAttribute("userName", user.getUserName());
            model.addAttribute("password", EncoderByMd5(user.getPassword()));
            request.getSession().setAttribute("user", user);
            return "login";//注册成功返回登录页
        }catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "signIn";//出错的话重新注册
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


    //Login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) throws Exception{
        try {
            user.setPassword(EncoderByMd5(user.getPassword()));
            //If pass, set attribute to session, then redirect to index page.
            if (userService.checkLogin(user)) {
                request.getSession().setAttribute("user", user);
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
}