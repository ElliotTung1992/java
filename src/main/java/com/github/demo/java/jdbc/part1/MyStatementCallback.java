package com.github.demo.java.jdbc.part1;

import org.springframework.dao.DataAccessException;
import org.springframework.lang.Nullable;

import java.sql.SQLException;
import java.sql.Statement;

public interface MyStatementCallback<T> {
    @Nullable
    T doInStatement(Statement statement) throws SQLException, DataAccessException;
}