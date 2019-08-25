package com.example.springmvc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by yuxl on 2019/1/24.
 * 自定义过滤器，打印出请求的url
 */
public class MyFilter implements Filter {
   @Override
   public void doFilter(ServletRequest servletRequest,ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      HttpServletRequest request =(HttpServletRequest) servletRequest;
      System.out.println(request.getRequestURL());
     filterChain.doFilter(servletRequest,servletResponse);
   }
}