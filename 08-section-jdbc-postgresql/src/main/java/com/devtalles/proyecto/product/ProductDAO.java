package com.devtalles.proyecto.product;

import com.devtalles.proyecto.db.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO = DATA ACCESS OBJECT
public class ProductDAO {

    private final Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Product product) throws SQLException {
        String sql = "INSERT INTO products (name, price, stock, category_id) VALUES (?, ?, ?, ?)";

        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setLong(4, product.getCategory().getId());

            int rows = statement.executeUpdate();
            message(rows, "Producto Agregado exitosamente", "");

        }
    }

    public List<Product> findAll() throws SQLException {
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
        ){
            while (resultSet.next()) {
                Product product = mapResult(resultSet);
                products.add(product);
            }

        }

        return products;
    }

    public void update(Product product) throws SQLException {
        String sql = "UPDATE products SET name = ?, price = ?, stock = ?, cateogry_id = ? WHERE id = ?";

        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setLong(4, product.getCategory().getId());
            statement.setLong(5, product.getId());

            int rows = statement.executeUpdate();
            message(rows, "Producto Actualizado exitosamente", "No existe el producto a actualizar con el id: " + product.getId());

        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";

        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ){

            statement.setLong(1, id);
            int rows = statement.executeUpdate();
            message(rows, "Producto Eliminado exitosamente", "No existe el producto a eliminar con el id: " + id);

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
