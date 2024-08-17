package com.johnbr.java_spreadsheet_report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection connect;
    public Connection getConnection() {
        String databaseName = "spreadsheet_report";
        String databaseUser = "root";
        String databasePassword = "root";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (SQLException e) {
            e.getCause();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connect;
    }

}
