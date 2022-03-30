<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: 唐广
  Date: 2021/10/16
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Question> list = (List<Question>) request.getAttribute("question");
%>
<center>

    <form action="/myWeb/exam" method="get">

        <table border="2">
<%
    for(Question question:list){
%>
            <tr>
                <td>题目:</td>
                <td><input type="text"  value=<%=question.getTitle()%> disabled></td>
            </tr>
            <tr>
                <td>A:</td>
                <td><input type="text"  value=<%=question.getOptionA()%> disabled></td>
            </tr>
            <tr>
                <td>B:</td>
                <td><input type="text"  value=<%=question.getOptionB()%> disabled></td>
            </tr>
            <tr>
                <td>C:</td>
                <td><input type="text"  value=<%=question.getOptionC()%> disabled></td>
            </tr>
            <tr>
                <td>D:</td>
                <td><input type="text"  value=<%=question.getOptionD()%> disabled></td>
            </tr>
            <tr>
                <td>答案:</td>
                <td>
                    <input type="radio" name=<%="answer"+question.getQuestionId()%> value="A" >A
                    <input type="radio" name=<%="answer"+question.getQuestionId()%> value="B" >B
                    <input type="radio" name=<%="answer"+question.getQuestionId()%> value="C" >C
                    <input type="radio" name=<%="answer"+question.getQuestionId()%> value="D" >D
                </td>
            </tr>
<%
    }
%>
        <tr>
            <td><input type="submit" value="提交答案"/></td>
            <td><input type="reset" ></td>
        </tr>
    </table>
</form>
</center>