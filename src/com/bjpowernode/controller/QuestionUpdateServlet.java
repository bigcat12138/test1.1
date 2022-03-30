package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取出注册参数
        Integer questionId;
        String title,optionA,optionB,optionC,optionD,answer;
        questionId=Integer.valueOf(request.getParameter("questionId"));
        title=request.getParameter("title");
        optionA=request.getParameter("optionA");
        optionB=request.getParameter("optionB");
        optionC=request.getParameter("optionC");
        optionD=request.getParameter("optionD");
        answer=request.getParameter("answer");
        //通过QuestionDao完成试题注册
        int result=0;
        QuestionDao questionDao=new QuestionDao();
        result=questionDao.update(new Question(questionId,title,optionA,optionB,optionC,optionD,answer));
        //获取输出流
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        if (result==1){
            out.print("<font color=red>恭喜，修改成功！ </font>");
        }else {
            out.print("<font color=red>很遗憾，修改失败！ </font>");
        }
    }
}

