package com.bjpowernode.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class OneFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    //首先判  断是否是访问login相关文件
        HttpServletRequest rq=(HttpServletRequest) servletRequest;
        String uri=rq.getRequestURI();
        if (uri.indexOf("login")!=-1||"/myWeb/".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //到此处说明不是login
        if (rq.getSession(false)==null){
            //打回登录页面
            rq.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
