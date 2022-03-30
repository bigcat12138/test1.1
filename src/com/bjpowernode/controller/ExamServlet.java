package com.bjpowernode.controller;

import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ExamServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        List<Question> list=(List<Question>) session.getAttribute("key");
        int fraction=0;

        for (Question question:list){
            if(question.getAnswer().equals(request.getParameter("answer"+question.getQuestionId())))
                fraction+=25;
        }
        request.setAttribute("fraction",fraction);
        request.getRequestDispatcher("fraction.jsp").forward(request,response);
    }
}
