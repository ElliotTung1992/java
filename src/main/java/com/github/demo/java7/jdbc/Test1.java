package com.github.demo.java7.jdbc;

import java.sql.*;

public class Test1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Test1 test1 = new Test1();
        Class.forName("com.mysql.jdbc.Driver");
        test1.setSchema();

    }

    public void setSchema() throws SQLException {
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo", "root", "123456")) {
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM people")) {
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        }
    }
}
