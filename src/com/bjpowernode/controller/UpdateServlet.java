package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password,sex,email,userId;
        //取出请求参数
        userId = request.getParameter("userId");
        userName=request.getParameter("userName");
        password=request.getParameter("password");
        sex=request.getParameter("sex");
        email=request.getParameter("email");
        //返回结果
        //设置返回格式
        response.setContentType("text/html;charset=utf-8");
        //拿到打印对象
        PrintWriter pw=response.getWriter();
        pw.print("<center>\n" +
                "    <form action=\"/myWeb/user/update\">\n" +
                "        <table border=\"2\">\n" +
                "            <tr>\n" +
                "                <td>用户Id</td>\n" +
                "                <td><input type=\"text\" name=\"userId\" value='"+userId+"' readOnly></td>\n " +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td>用户姓名</td>\n" +
                "                <td><input type=\"text\" name=\"userName\" value='"+userName+"'></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td>用户密码</td>\n" +
                "                <td><input type=\"text\" name=\"password\" value='"+password+"'></td>\n" +
                "            </tr>\n");

        if ("男".equals(sex)){
            pw.print( "            <tr>\n"+
                    "                <td>用户性别</td>\n" +
                    "                <td>\n" +
                    "                    <input type=\"radio\" name=\"sex\" value=\"男\" checked>男\n " +
                    "                    <input type=\"radio\" name=\"sex\" value=\"女\">女\n" +
                    "                </td>\n" +
                    "            </tr>\n" );
        }else {
            pw.print( "            <tr>\n"+
                    "                <td>用户性别</td>\n" +
                    "                <td>\n" +
                    "                    <input type=\"radio\" name=\"sex\" value=\"男\">男\n" +
                    "                    <input type=\"radio\" name=\"sex\" value=\"女\" checked>女\n " +
                    "                </td>\n" +
                    "            </tr>\n" );
        }



        pw.print("            <tr>\n" +
                "                <td>用户邮箱</td>\n" +
                "                <td><input type=\"text\" name=\"email\" value='"+email+"'></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td><input type=\"submit\"></td>\n" +
                "                <td><input type=\"reset\"></td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "    </form>\n" +
                "</center>");
    }
}
