package com.devtalles.proyecto.product.persistence;

import com.devtalles.proyecto.category.model.Category;
import com.devtalles.proyecto.category.persistence.CategoryDAO;
import com.devtalles.proyecto.db.ConnectionPool;
import com.devtalles.proyecto.product.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//DAO = DATA ACCESS OBJECT
public class ProductDAO {

    private final Connection connection;
    private final CategoryDAO categoryDAO;

    public ProductDAO(Connection connection, CategoryDAO categoryDAO) {
        this.connection = connection;
        this.categoryDAO = categoryDAO;
    }

    public Product save(Product product) throws SQLException {
        String sql = "INSERT INTO products (name, price, stock, category_id) VALUES (?, ?, ?, ?)";

        try (
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setLong(4, product.getCategory().getId());

            int rows = statement.executeUpdate();
            if(rows > 0) {
                try(ResultSet generatedKeys = statement.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        product.setId(generatedKeys.getLong(1));
                        System.out.println("Producto ingresado correctamente...");
                    }
                }
            }

        }
        return product;
    }

    public List<Product> findAll() throws SQLException {
        String sql = "SELECT p.id, p.name, p.price, p.stock, p.category_id, c.name as category_name " +
                "FROM products p JOIN categories c ON p.category_id = c.id";
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

    public Optional<Product> findById(Long id) throws SQLException {
        String sql = "SELECT p.id, p.name, p.price, p.stock, p.category_id, c.name as category_name " +
                "FROM products p JOIN categories c ON p.category_id = c.id WHERE p.id = ?";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    return Optional.of(mapResult(resultSet));
                }
            }
        }
        return Optional.empty();
    }

    public List<Product> findByCategoryId(Long categoryId) throws SQLException {
        String sql = "SELECT p.id, p.name, p.price, p.stock, p.category_id, c.name as category_name " +
                "FROM products p JOIN categories c ON p.category_id = c.id WHERE p.category_id = ?";
        List<Product> products = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setLong(1, categoryId);
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    products.add(mapResult(resultSet));
                }
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

    public boolean productExistsById(Long id) throws SQLException {
        if(id==null) return  false;

        String sql = "SELECT Count(*) FROM products WHERE id = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private void message(int rows,String success, String fail){
        if(rows>0){
            System.out.println(success);
        }else if(!fail.isBlank()){
            System.out.println(fail);
        }
    }

    private Product mapResult(ResultSet resultSet) throws SQLException {
        Long idCategory = resultSet.getLong("category_id");
        String nameCategory = resultSet.getString("category_name");

        Category category = new Category(idCategory, nameCategory);

        Product product = new Product(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock"),
                category
        );

        return product;
    }
}
