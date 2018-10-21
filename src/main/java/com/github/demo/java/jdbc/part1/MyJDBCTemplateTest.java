package com.github.demo.java.jdbc.part1;

import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBCTemplateTest {

    public static void main(String[] args) {
        Object execute = new MyJDBCTemplate().execute(new MyStatementCallback<Object>() {

            @Override
            public Object doInStatement(Statement statement) throws SQLException, DataAccessException {
                return statement.executeQuery("select * from sys_user");
            }
        });
    }
}
