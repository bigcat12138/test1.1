package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao =new UserDao();
        String userName,password,sex,email,userId;
        int result=0;
        //取出请求参数
        userId = request.getParameter("userId");
        userName=request.getParameter("userName");
        password=request.getParameter("password");
        sex=request.getParameter("sex");
        email=request.getParameter("email");
        result=userDao.update(new Users(Integer.valueOf(userId),userName,password,sex,email));
        response.setContentType("text/html;charset=utf-8");
        //拿到打印对象
        PrintWriter pw=response.getWriter();
        if (result==1){
            pw.print("<font font_size=100 color=red>恭喜"+userName+"修改成功！</font>");
        }else {
            pw.print("<font color=red>很遗憾，修改失败！<font>");
        }
    }
}
