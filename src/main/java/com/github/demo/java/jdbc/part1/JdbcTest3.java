package com.github.demo.java.jdbc.part1;

import java.sql.*;

public class JdbcTest3 {

    public static void main(String[] args) {

        String sql;
        String url = "jdbc:mysql://localhost:3306/demo?characterEncoding=utf8&useSSL=true";
        String userName = "root";
        String password = "123456";

        Connection conn = null;
        Statement statement = null;

        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //建立连接
            conn = DriverManager.getConnection(url, userName, password);

            //设置手动提交
            conn.setAutoCommit(false);

            long start = System.currentTimeMillis();

            //创建可以执行sql的Statement
            statement = conn.createStatement();
            for (int i = 0; i < 1000000; i++) {
                statement.addBatch("INSERT INTO people (name, age) VALUES ('feng" + i + "'," + i +")");
            }

            //执行sql获取返回结果
            statement.executeBatch();

            //提交事务
            conn.commit();

            long end = System.currentTimeMillis();

            System.out.println(end - start);

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
