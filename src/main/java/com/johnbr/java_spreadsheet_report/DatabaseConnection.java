package com.johnbr.java_spreadsheet_report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection databaseConnection;
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        String databaseName = "";
        String databaseUser = "";
        String databasePassword = "";
        String url = "jdbc.mysql://localhost/" + databaseName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseConnection = DriverManager.getConnection(url, databaseUser, databasePassword);

        return databaseConnection;
    }


}
