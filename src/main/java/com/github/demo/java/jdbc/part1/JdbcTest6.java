package com.github.demo.java.jdbc.part1;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JdbcTest6 {

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
            sql = "select * from people p where 1=1 and p.timeStamp > ? and p.timeStamp < ?";
            statement = conn.prepareStatement(sql);
            Timestamp first = new Timestamp(getTime("2018-05-02 11:28:18"));
            Timestamp sed = new Timestamp(getTime("2018-05-04 11:28:18"));

            statement.setTimestamp(1, first);
            statement.setTimestamp(2, sed);

            //执行sql获取返回结果
            ResultSet resultSet = statement.executeQuery();

            //处理返回结果
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(id);
                System.out.println(name);
                System.out.println(age);
            }

            //释放资源
            resultSet.close();
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

    public static long getTime(String dateStr){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
