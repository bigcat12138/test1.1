package com.bjpowernode.listener;

import com.bjpowernode.util.JdbcUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        Map map = new HashMap();
        //创建20个连接
        for (int i = 0; i <20 ; i++) {
            Connection con=jdbcUtil.createCon();
            System.out.println("连接"+con+"被创建");
            map.put(con,true);
        }
        //将连接装入全局对象
        sce.getServletContext().setAttribute("con",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    //在这关闭连接，tomcat关闭时一同关闭
        Map map=(Map) sce.getServletContext().getAttribute("con");
        Set set= map.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            Connection con=(Connection) iterator.next();
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连接"+con+"被销毁");
        }
    }
}
