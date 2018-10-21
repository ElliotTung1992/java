package com.github.demo.java.jdbc.part1;

import java.sql.*;

public class MyJDBCTemplate {

    public <T> T execute(MyStatementCallback<T> action) {

        String url = "jdbc:mysql://localhost:3306/guns";
        String userName = "root";
        String password = "123456";

        Connection conn = null;
        Statement statement = null;

        Object obj = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //建立连接
            conn = DriverManager.getConnection(url, userName, password);

            //创建可以执行sql的Statement
            statement = conn.createStatement();

            //执行sql获取返回结果
            T resultSet = action.doInStatement(statement);

            obj = resultSet;
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
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) obj;
    }
}
