package com.xiaozl.initialwork1.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginInterceptor
 *
 * @author Daydreamer
 * @date 2017/12/1 14:10
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //到登录页准备登录
        if(request.getServletPath().startsWith("/login"))
            return true;
        else if (request.getServletPath().startsWith("/index")){
            System.out.println("请先登录！");
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception{
//        System.out.println("========执行顺序：2.postHandle=========");
//        if (modelAndView != null){//加入当前时间
//            modelAndView.addObject("var", "测试postHandle");
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception e) throws Exception{
//        System.out.println("=======执行顺序：3.afterCompletion");
    }
}
