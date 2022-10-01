package com.example.demo.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestResponseLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        System.out.println(
//                "Logging Request  { " + req.getMethod() + " }  { " +
//                req.getRequestURI()  + " }");
        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println(
//                "Logging Response " + res.getContentType());
    }
}
