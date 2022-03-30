package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao=new UserDao();
        String userName,password;
        int result=0;
        //设置请求对象字符集
        request.setCharacterEncoding("utf-8");
        //取出登录信息
        userName=request.getParameter("userName");
        password=request.getParameter("password");
        //验证
        result=userDao.login(userName,password);
        //response.setContentType("text/html;charset=utf-8");
        if (result==1){
            HttpSession session=request.getSession();
            //请求转发
            response.sendRedirect("/myWeb/index.html");
        }else{
            response.sendRedirect("/myWeb/login_error.html");
        }
    }
}
