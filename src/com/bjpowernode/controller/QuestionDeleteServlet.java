package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //拿到试题编号
        String questionId=request.getParameter("questionId");
        //根据编号删除试题
        QuestionDao qd=new QuestionDao();
        int result= 0;
        result=qd.delete(questionId);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if (result==1){
            out.print("<font color=red>恭喜，删除成功！ </font>");
        }else {
            out.print("<font color=red>很遗憾，删除失败！ </font>");
        }
    }
}
