package com.devtalles.proyecto.product.service;

import com.devtalles.proyecto.category.model.Category;
import com.devtalles.proyecto.db.ConnectionPool;
import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.exceptions.ProductNotFoundException;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.model.Product;
import com.devtalles.proyecto.product.repository.ProductRepositoryServices;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() throws InvalidProductException {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id);
    }

    public Optional<Product> getProductByIdDB(Long id) throws ProductNotFoundException, SQLException {
        try(Connection connection = ConnectionPool.getConnection()){
            return productRepository.findByIdDB(connection,id);
        }
    }

    public void saveProduct(Product product) throws InvalidProductException, SQLException {
        ProductValidator.validate(product);
        Connection connection = null;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);

            Optional<Category> optionalCategory = ((ProductRepositoryServices)productRepository)
                    .getCategoryDAO().findCategoryByName(connection, product.getName());

            if(optionalCategory.isPresent()) {
                if(!productRepository.existsById(product.getId())){
                    product.setCategory(optionalCategory.get());
                }else{
                    throw new InvalidProductException("¡El producto que desea agregar ya existe!");
                }
            }else{
                Optional<Category> optionalNewCategory = ((ProductRepositoryServices)productRepository)
                        .getCategoryDAO().save(connection, product.getCategory());
                optionalNewCategory.ifPresent(product::setCategory);
            }
            productRepository.save(connection, product);

            connection.commit();
            System.out.println("Producto guardado exitosamente...");
        } catch (SQLException | InvalidProductException e){
            if(connection != null){
                connection.rollback();
            }
            throw e;
        }finally {
            if (connection != null) {
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e){
                    System.out.println("Error al cerrar la conexion... " + e.getMessage());
                }
            }
        }

    }

    public void deleteProduct(Long id) throws ProductNotFoundException, SQLException {
        Connection connection = null;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);

            Optional<Product> optionalProduct = productRepository.findById(id);
            if(optionalProduct.isPresent()){
                productRepository.delete(connection, id);
                connection.commit();
                System.out.println("Producto eliminado exitosamente...");
            }else{
                throw new ProductNotFoundException("¡El producto que desea eliminar no existe!");
            }
        }catch (SQLException e){
            if(connection != null){
                connection.rollback();
            }
            throw e;
        }finally {
            if (connection != null) {
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e){
                    System.out.println("Error al cerrar la conexion... " + e.getMessage());
                }
            }
        }

    }

    public void updateProduct(Product product) throws ProductNotFoundException, InvalidProductException, SQLException {
        Connection connection = null;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);

            ProductValidator.validate(product);
            Optional<Product> optionalProduct = ((ProductRepositoryServices)productRepository)
                    .getProductDAO().findById(connection, product.getId());

            if(optionalProduct.isPresent()){
                Optional<Category> category = ((ProductRepositoryServices)productRepository)
                        .getCategoryDAO().findCategoryByName(connection, product.getCategory().getName());
                if(category.isPresent()){
                    product.setCategory(category.get());

                }else{
                    Optional<Category> newCategory = ((ProductRepositoryServices)productRepository)
                            .getCategoryDAO().save(connection, product.getCategory());
                    newCategory.ifPresent(product::setCategory);
                }
                productRepository.update(connection, Optional.of(product));
                connection.commit();
                System.out.println("Producto actualizado exitosamente...");
            }else{
                throw new ProductNotFoundException("¡El producto que desea actualizar no existe!");
            }
        }catch (SQLException e){
            if(connection != null){
                connection.rollback();
            }
            throw e;
        }finally {
            if (connection != null) {
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e){
                    System.out.println("Error al cerrar la conexion... " + e.getMessage());
                }
            }
        }

    }
}
