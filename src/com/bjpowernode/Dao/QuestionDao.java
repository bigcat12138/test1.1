package com.bjpowernode.Dao;

import com.bjpowernode.entity.Question;
import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private JdbcUtil jdbcUtil=new JdbcUtil();

    //注册试题的方法
    public int Add(Question question, HttpServletRequest request){
        String sql="insert into question(title,optionA,optionB,optionC,optionD,answer) value(?,?,?,?,?,?)";
        PreparedStatement ps= jdbcUtil.createStatement(sql, request);
        int result=0;
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close(request);
        }

        return result;
    }
    //根据编号查询
    public Question findById(Integer questionId){
        String sql="select * from question where questionId=?";
        PreparedStatement ps=jdbcUtil.createStatement(sql);
        ResultSet res=null;
        Question question=null;
        try {
            ps.setInt(1,questionId);
            res=ps.executeQuery();
            while (res.next()) {
                String title = res.getString("title");
                String optionA = res.getString("optionA");
                String optionB = res.getString("optionB");
                String optionC = res.getString("optionC");
                String optionD = res.getString("optionD");
                String answer = res.getString("answer");
                question=new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(res);
        }
        return question;
    }
    //查询所有试题
    public List find(){
        String sql="select * from question";
        ResultSet res=null;
        List list=new ArrayList();
        PreparedStatement ps=jdbcUtil.createStatement(sql);
        try {
            ps.executeQuery();
            res=ps.executeQuery();
            while (res.next()){
                Integer questionId=res.getInt("questionId");
                String title=res.getString("title");
                String optionA=res.getString("optionA");
                String optionB=res.getString("optionB");
                String optionC=res.getString("optionC");
                String optionD=res.getString("optionD");
                String  answer=res.getString("answer");
                list.add(new Question(questionId,title,optionA,optionB,optionC,optionD,answer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(res);
        }
        return list;
    }
    //根据编号删除试题
    public int delete(String questionId){
        String sql="delete from question where questionId=?";
        PreparedStatement ps=jdbcUtil.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1,questionId);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close();
        }
        return result;
    }
    //根据试题编号修改
    public int update(Question question){
        String sql="update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
        PreparedStatement ps= jdbcUtil.createStatement(sql);
        int result=0;
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setInt(7,question.getQuestionId());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close();
        }

        return result;
    }
    //随机生成4道题
    public List rand(){
        String sql ="select * from question order by rand() limit 0,4";
        ResultSet res=null;
        List list=new ArrayList();
        PreparedStatement ps=jdbcUtil.createStatement(sql);
        try {
            ps.executeQuery();
             res=ps.executeQuery();
            while (res.next()){
                Integer questionId=res.getInt("questionId");
                String title=res.getString("title");
                String optionA=res.getString("optionA");
                String optionB=res.getString("optionB");
                String optionC=res.getString("optionC");
                String optionD=res.getString("optionD");
                String  answer=res.getString("answer");
                list.add(new Question(questionId,title,optionA,optionB,optionC,optionD,answer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(res);
        }
        return list;
    }

}
