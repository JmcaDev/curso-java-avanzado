package com.devtalles.proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL="jdbc:postgresql://ep-solitary-surf-aqdanote-pooler.c-8.us-east-1.aws.neon.tech/jdbc-curso?sslmode=require";
    private static final String USER="neondb_owner";
    private static final String PASSWORD="npg_45UfOrHYhGzc";

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
