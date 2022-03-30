package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao=new QuestionDao();
        //通过请求转发交给question_find.jsp
        request.setAttribute("key",questionDao.find());
        request.getRequestDispatcher("/question_find.jsp").forward(request,response);
    }
}
