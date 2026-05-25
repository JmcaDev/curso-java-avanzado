package com.devtalles.proyecto.product;

import com.devtalles.proyecto.db.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO = DATA ACCESS OBJECT
public class ProductDAO {

    public void save(Product product) {
        String sql = "INSERT INTO prodcuts (name, price, stock) VALUES (?, ?, ?)";

        try (
                Connection connection = ConnectionDB.connection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());

            int rows = statement.executeUpdate();

            if(rows>0){
                System.out.println("Producto insertado exitosamente");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = ConnectionDB.connection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ){
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock")
                );

                products.add(product);
            }

            System.out.println("Conectado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return products;
    }
}
