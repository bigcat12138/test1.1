package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        //提取userId
        String userId =request.getParameter("userId");
        //执行删除
        int res=userDao.delete(userId);
        //输出结果
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        if (res==1){
            pw.print("<font font_size=100 color=red>删除成功！</font>");
        }else{
            pw.print("<font font_size=100 color=red>删除失败！</font>");
        }
    }
}
