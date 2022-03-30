package com.bjpowernode.Dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcUtil jdbcUtil= new JdbcUtil();
    //用户注册
    public int userAdd(Users users){
        String sql="insert into users(username,password,sex,email) value(?,?,?,?)";
        PreparedStatement ps= jdbcUtil.createStatement(sql);
        int result=0;
        try {
            ps.setString(1,users.getUserName());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close();
        }

        return result;
    }
    //重载用户注册
    public int userAdd(Users users, HttpServletRequest request){
        String sql="insert into users(username,password,sex,email) value(?,?,?,?)";
        PreparedStatement ps= jdbcUtil.createStatement(sql, request);
        int result=0;
        try {
            ps.setString(1,users.getUserName());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close(request);
        }

        return result;
    }
    //查询所有用户信息
    public List userFindAll(){
        String sql="select * from users";
        ResultSet res=null;
        List list=new ArrayList();
        PreparedStatement ps=jdbcUtil.createStatement(sql);
        try {
            ps.executeQuery();
            res=ps.executeQuery();
            while (res.next()){
                Integer userId=res.getInt("userId");
                String userName=res.getString("userName");
                String password=res.getString("password");
                String sex=res.getString("sex");
                String  email=res.getString("email");
                Users users =new Users(userId,userName,password,sex,email);
                list.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(res);
        }
        return list;
    }

    //根据用户编号删除用户
    public int delete(String userId){
        String sql="delete from users where userId=?";
        int result=0;
        PreparedStatement ps = jdbcUtil.createStatement(sql);
        try {
            ps.setString(1, userId);
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return result;
    }
    //登陆验证
    public int login(String userName,String password){
        String sql="select count(*) from users where userName=? and password=?";
        PreparedStatement ps= jdbcUtil.createStatement(sql);
        ResultSet rs=null;
        int result=0;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while (rs.next()){
                result=rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(rs);
        }
        return result;
    }

    //传入一个Users根据用户编号修改用户
    public int update(Users users){
        String sql="update users set userName=?,password=?,sex=?,email=? where userId=?";
        PreparedStatement ps=jdbcUtil.createStatement(sql);
        int result=0;
        try {
            ps.setString(1,users.getUserName());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            ps.setInt(5,users.getUserId());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return result;
    }
}
