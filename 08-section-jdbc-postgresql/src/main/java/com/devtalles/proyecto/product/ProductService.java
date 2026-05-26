package com.devtalles.proyecto.product;

import com.devtalles.proyecto.category.Category;
import com.devtalles.proyecto.category.CategoryDAO;
import com.devtalles.proyecto.db.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductService {

    public void saveProductWithCategory(Product product, Category category) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);//Inicio de la transaccion

            CategoryDAO categoryDAO = new CategoryDAO(connection);
            ProductDAO productDAO = new ProductDAO(connection);

            Category newCategory = categoryDAO.save(category);
            product.setCategory(newCategory);
            productDAO.save(product);

            connection.commit();

            System.out.println("Producto agregado exitosamente...");

        }catch (SQLException e){

            if(connection != null){
                connection.rollback();
            }
            System.out.println("Error: " + e.getMessage());
            throw e;
        }finally {
            if(connection != null){
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Error al cerrar la conexion: " + e.getMessage());
                }
            }
        }
    }

    public void updateProduct(Product product, Category category) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);//Inicio de la transaccion

            ProductDAO productDAO = new ProductDAO(connection);

            productDAO.update(product);

            connection.commit();

            System.out.println("Producto Actualizado exitosamente...");

        }catch (SQLException e){

            if(connection != null){
                connection.rollback();
            }
            System.out.println("Error: " + e.getMessage());
            throw e;
        }finally {
            if(connection != null){
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Error al cerrar la conexion: " + e.getMessage());
                }
            }
        }
    }

    public void deleteProduct(Long id) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);//Inicio de la transaccion

            ProductDAO productDAO = new ProductDAO(connection);

            productDAO.delete(id);

            connection.commit();

            System.out.println("Producto Eliminado exitosamente...");

        }catch (SQLException e){

            if(connection != null){
                connection.rollback();
            }
            System.out.println("Error: " + e.getMessage());
            throw e;
        }finally {
            if(connection != null){
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Error al cerrar la conexion: " + e.getMessage());
                }
            }
        }
    }

    public List<Product> findProducts() throws SQLException {
        Connection connection = null;
        try {

            connection = ConnectionPool.getConnection();

            ProductDAO productDAO = new ProductDAO(connection);

            return productDAO.findAll();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            throw e;
        }finally {
            if(connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Error al cerrar la conexion: " + e.getMessage());
                }
            }
        }
    }

}
