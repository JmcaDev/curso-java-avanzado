package com.devtalles.proyecto;

import com.devtalles.proyecto.db.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Intentando conectar a la base de datos");

        try (Connection connection = ConnectionDB.connection();) {
            System.out.println("Conectado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}