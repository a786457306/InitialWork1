package com.xiaozl.initialwork1.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * LoginFilter
 *
 * @author Daydreamer
 * @date 2017/12/17 16:41
 */
public class LoginFilter implements Filter {

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig){
        System.out.println("初始化");
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        String userName = (String)session.getAttribute("user.getUserName()");
        if (userName != "admin"){
            servletResponse.sendRedirect(((HttpServletRequest) request).getContextPath() + "/index");
            System.out.println("没有访问权限");
        }
    }

    public void destroy(){

    }
}
