package com.github.demo.java.jdbc.part1;

import java.sql.*;

public class JdbcTest2 {

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

            sql = "select * from people where 1=1 and id = ? and name = ?";

            //创建可以执行sql的Statement
            statement = conn.prepareStatement(sql);
            statement.setInt(1, 1);
            statement.setString(1, "dong");
            statement.setInt(1, 27);

            //执行sql获取返回结果
            ResultSet resultSet = statement.executeQuery();

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
}
