package com.xiaozl.initialwork1.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * LoginFilter
 *
 * @author Daydreamer
 * @date 2017/11/29 14:00
 */
public class DemoFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig){
        System.out.println("初始化");
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Demo1过滤前");
        System.out.println(filterConfig.getInitParameter("param1"));//具体配置在web.xml里
        chain.doFilter(request, response);
        System.out.println("Demo1过滤后");
    }

    public void destroy(){
        System.out.println("销毁");
    }

}
