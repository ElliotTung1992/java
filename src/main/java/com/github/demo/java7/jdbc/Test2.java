package com.github.demo.java7.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) throws SQLException {
        Test2 test2 = new Test2();
        test2.useSQLData();
    }

    public void useSQLData() throws SQLException {
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo", "root", "123456")) {
            Map<String,Class<?>> typeMap = new HashMap<String,Class<?>>();
            typeMap.put("java7People.People", People.class);
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM people")) {
                while (rs.next()) {
                    System.out.println(rs.getObject(1, People.class));
                }
            }
        }
    }
}

class People{

    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
