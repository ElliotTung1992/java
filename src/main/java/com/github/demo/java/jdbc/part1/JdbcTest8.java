package com.github.demo.java.jdbc.part1;

import java.io.*;
import java.sql.*;

public class JdbcTest8 {

    public static void main(String[] args) {

        String sql;
        String url = "jdbc:mysql://localhost:3306/demo";
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

            //创建可以执行sql的Statement
            sql = "INSERT INTO people (name, bbb) VALUES (?, ?);";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "yan");
            statement.setBlob(2, new FileInputStream("E:/timg.jpg"));


            //执行sql获取返回结果
            statement.executeUpdate();

            String sql2 = "select * from people where 1=1 and id = ?";
            statement2 = conn.prepareStatement(sql2);
            statement2.setInt(1, 13);

            ResultSet resultSet = statement2.executeQuery();

            //处理返回结果
            while (resultSet.next()){
                Blob bbb = resultSet.getBlob("bbb");
                InputStream binaryStream = bbb.getBinaryStream();
                FileOutputStream fileOutputStream = new FileOutputStream("E:/aaa.jpg");

                int temp = 0;
                while ((temp=binaryStream.read()) != -1){
                    fileOutputStream.write(temp);
                }
            }

            //释放资源
            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
