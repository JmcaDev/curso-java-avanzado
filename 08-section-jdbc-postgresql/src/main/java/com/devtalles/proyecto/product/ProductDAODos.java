package com.devtalles.proyecto.product;

import com.devtalles.proyecto.db.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO = DATA ACCESS OBJECT
public class ProductDAODos {

    private Connection getConnection() throws SQLException {
        return ConnectionPool.getConnection();
    }

    public void save(Product product) {
        String sql = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());

            int rows = statement.executeUpdate();
            message(rows, "Producto Agregado exitosamente", "");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
        ){
            while (resultSet.next()) {
                Product product = mapResult(resultSet);
                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return products;
    }

    public void update(Long id, Product product) {
        String sql = "UPDATE products SET name = ?, price = ?, stock = ? WHERE id = ?";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setLong(4, id);

            int rows = statement.executeUpdate();
            message(rows, "Producto Actualizado exitosamente", "No existe el producto a actualizar con el id: " + id);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            statement.setLong(1, id);
            int rows = statement.executeUpdate();
            message(rows, "Producto Eliminado exitosamente", "No existe el producto a eliminar con el id: " + id);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void message(int rows,String success, String fail){
        if(rows>0){
            System.out.println(success);
        }else if(!fail.isBlank()){
            System.out.println(fail);
        }
    }

    private Product mapResult(ResultSet resultSet) throws SQLException {
        Product product = new Product(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock")
        );

        return product;
    }
}
