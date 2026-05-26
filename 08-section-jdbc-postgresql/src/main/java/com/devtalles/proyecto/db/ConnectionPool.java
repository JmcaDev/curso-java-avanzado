package com.devtalles.proyecto.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static HikariDataSource dataSource;
    private static Dotenv dotenv = Dotenv.load();

    static {
        System.out.println("Configuracion hikari");

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(dotenv.get("DB_URL"));
        config.setUsername(dotenv.get("DB_USER"));
        config.setPassword(dotenv.get("DB_PASSWORD"));

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        config.setIdleTimeout(30000);
        config.setConnectionTimeout(30000);

        config.setLeakDetectionThreshold(15000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}
