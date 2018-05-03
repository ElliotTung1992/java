package com.github.demo.java.jdbc.part1;

import java.sql.*;

public class JdbcTest4 {

    public static void main(String[] args) {

        String sql;
        String url = "jdbc:mysql://localhost:3306/demo?characterEncoding=utf8&useSSL=true";
        String userName = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;

        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //建立连接
            conn = DriverManager.getConnection(url, userName, password);

            //设置手动提交
            conn.setAutoCommit(false);


            //创建可以执行sql的Statement
            sql = "INSERT INTO people (name, age) VALUES (?, ?);";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "dong");
            statement.setInt(2, 27);
            statement.execute();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //第二次的错误提交
            statement2 = conn.prepareStatement(sql);
            statement2.setString(1, "dong");
            statement2.execute();

            //提交事务
            conn.commit();

            //释放资源
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement2 != null){
                try {
                    statement2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
