package com.devtalles.proyecto.product.repository;

import com.devtalles.proyecto.category.persistence.CategoryDAO;
import com.devtalles.proyecto.db.ConnectionPool;
import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.exceptions.ProductNotFoundException;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.model.Product;
import com.devtalles.proyecto.product.model.ProductCategory;
import com.devtalles.proyecto.product.persistence.ProductDAO;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Getter
public class ProductRepositoryServices implements ProductRepository {

    private final List<Product> products;
    private final ProductDAO productDAO;
    private final CategoryDAO categoryDAO;

    public ProductRepositoryServices(CategoryDAO categoryDAO) throws SQLException, InvalidProductException {
        productDAO = new ProductDAO(categoryDAO);
        this.categoryDAO = categoryDAO;
        try(Connection connection = ConnectionPool.getConnection();){
            products = productDAO.findAll(connection);
        }catch (SQLException e){
            throw new InvalidProductException("Error al inicializar la lista: " + e.getMessage());
        }
    }

    @Override
    public List<Product> findAll() throws InvalidProductException {
        if(products.isEmpty()) {
            throw new InvalidProductException("La lista esta vacia");
        }

        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Optional<Product> findByIdDB(Connection connection, Long id) throws SQLException {
        return productDAO.findById(connection, id);
    }

    @Override
    public Product save(Connection connection,Product product) throws SQLException {
        Product newProduct = productDAO.save(connection, product);
        products.add(newProduct);
        return newProduct;
    }

    @Override
    public void delete(Connection connection, Long id) throws SQLException {
        products.removeIf(p -> p.getId().equals(id));
        productDAO.delete(connection, id);
    }

    @Override
    public List<Product> findByCategory(ProductCategory category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }

    @Override
    public void update(Connection connection, Optional<Product> product) throws ProductNotFoundException, SQLException {
        if(product.isPresent()) {
            Long idToUpdate = product.get().getId();
            int index = findIndexById(idToUpdate);
            if(index != -1){
                products.set(index, product.get());
                productDAO.update(connection, product.get());
            }else{
                throw new ProductNotFoundException("El producto que quiere actualizar no existe");
            }
        }else{
            throw new ProductNotFoundException("El producto que quiere actualizar no existe");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return products.stream().anyMatch(p -> p.getId().equals(id));
    }

    private int findIndexById(Long id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
