package com.company.hashing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseUtil {
    private Connection getDbConnection() throws Exception{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/immunization", "root", "");
    }

    public ResultSet execQuery(String sql){
        if  (sql == null || sql.trim().equals(""))
            return null;

        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            return statement.executeQuery();

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }

        return null;

    }

    public void execUpdate(String sql) {
        if (sql == null || sql.trim().equals(""))
            return;

        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            statement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
}
