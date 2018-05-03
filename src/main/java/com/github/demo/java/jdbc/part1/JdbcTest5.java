package com.github.demo.java.jdbc.part1;

import java.sql.*;

public class JdbcTest5 {

    public static void main(String[] args) {

        String sql;
        String url = "jdbc:mysql://localhost:3306/demo";
        String userName = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //建立连接
            conn = DriverManager.getConnection(url, userName, password);

            //创建可以执行sql的Statement
            sql = "INSERT INTO people (name, age, date, timeStamp) VALUES (?,?,?,?);";
            statement = conn.prepareStatement(sql);

            Date date = new Date(System.currentTimeMillis());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            statement.setString(1, "liu");
            statement.setInt(2, 13);
            statement.setDate(3, date);
            statement.setTimestamp(4, timestamp);

            statement.execute();

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

    }
}
