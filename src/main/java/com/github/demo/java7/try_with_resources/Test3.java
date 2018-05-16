package com.github.demo.java7.try_with_resources;

import java.sql.*;

public class Test3 {

    public static void main(String[] args) {

        String sql = "select * from people";
        String url = "jdbc:mysql://localhost:3306/demo";
        String userName = "root";
        String password = "123456";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            try (
                    Connection connection = DriverManager.getConnection(url, userName, password);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                ) {

                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    System.out.println(id);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
