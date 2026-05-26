package com.devtalles.proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL="";
    private static final String USER="";
    private static final String PASSWORD="";

    private static DataBaseConnection instance;

    private Connection connection;

    private DataBaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conectado...");
    }

    public static synchronized DataBaseConnection getInstance() throws SQLException {
        if(instance==null || instance.connection.isClosed()){
            instance = new DataBaseConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
