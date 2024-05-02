package com.nhnacademy.jdbc;

import com.nhnacademy.jdbc.util.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbUtils.getConnection();

        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeUpdate("select * from jdbc_students where id='marco'");
    }
}
