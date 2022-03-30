package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password,sex,email;
        UserDao userDao=new UserDao();

        int result=0;
        //取出请求参数
        userName=request.getParameter("userName");
        password=request.getParameter("password");
        sex=request.getParameter("sex");
        email=request.getParameter("email");
        //调用添加命令 并向控制台报告用时
        Date oldDate=new Date();
        //result=userDao.userAdd(new Users(null,userName,password,sex,email));
        result=userDao.userAdd(new Users(null,userName,password,sex,email),request);
        Date newDate=new Date();
        System.out.println("本次添加共用了"+(newDate.getTime()-oldDate.getTime())+"ms");
        //返回结果
        //设置返回格式
        response.setContentType("text/html;charset=utf-8");
        //拿到打印对象
        PrintWriter pw=response.getWriter();
        if (result==1){
            pw.print("<font font_size=100 color=red>恭喜"+userName+"注册成功！</font>");
        }else {
            pw.print("<font color=red>很遗憾，注册失败！<font>");
        }
    }
}
