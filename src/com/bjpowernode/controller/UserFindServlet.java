package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao=new UserDao();
        List<Users> usersList=userDao.userFindAll();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.print("<center><table border=2>");
        pw.print("<tr>");
        pw.print("<td>用户编号</td>");
        pw.print("<td>用户姓名</td>");
        pw.print("<td>用户密码</td>");
        pw.print("<td>用户性别</td>");
        pw.print("<td>用户邮箱</td>");
        pw.print("<td>用户删除</td>");
        pw.print("<td>用户修改</td>");
        pw.print("</tr>");
        for (Users users:usersList) {
            pw.print("<tr>");
            pw.print("<td>"+users.getUserId()+"</td>");
            pw.print("<td>"+users.getUserName()+"</td>");
            pw.print("<td>******</td>");
            pw.print("<td>"+users.getSex()+"</td>");
            pw.print("<td>"+users.getEmail()+"</td>");
            pw.print("<td><a href='/myWeb/user/delete?userId="+users.getUserId()+"'>删除用户</a></td>");
            pw.print("<td><a href='/myWeb/update?" +
                    "userId="+users.getUserId()+
                    "&userName="+users.getUserName()+
                    "&password="+users.getPassword()+
                    "&sex="+users.getSex()+
                    "&email="+users.getEmail()+
                    "'>修改用户</a></td>");
            pw.print("</tr>");
        }
        pw.print("</table></center>");

    }
}
