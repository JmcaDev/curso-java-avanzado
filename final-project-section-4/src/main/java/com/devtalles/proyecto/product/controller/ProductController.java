package com.devtalles.proyecto.product.controller;

import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.exceptions.ProductNotFoundException;
import com.devtalles.proyecto.product.model.Product;
import com.devtalles.proyecto.product.service.ProductService;
import com.devtalles.proyecto.product.utils.Validates;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void addProduct(Product product) throws InvalidProductException, SQLException {
        Validates.ValidateObject(product, "El producto no puede ser nulo.");
        productService.saveProduct(product);
    }

    public void removeProduct(Long id) throws ProductNotFoundException, InvalidProductException, SQLException {
        Validates.validateNumber(id, "El ID no puede ser nulo");
        productService.deleteProduct(id);
    }

    public List<Product> getAllProducts() throws InvalidProductException {
        return productService.getAllProducts();
    }

    public Optional<Product> getProductById(Long id) throws ProductNotFoundException, InvalidProductException {
        Validates.validateNumber(id, "El ID no puede ser nulo");
        return productService.getProductById(id);
    }

    public Optional<Product> getProductByIdDB(Long id) throws ProductNotFoundException, InvalidProductException, SQLException {
        Validates.validateNumber(id, "El ID no puede ser nulo");
        return productService.getProductByIdDB(id);
    }

    public void updateProduct(Product product) throws ProductNotFoundException, InvalidProductException, SQLException {
        Validates.ValidateObject(product, "El producto no puede ser nulo.");
        productService.updateProduct(product);
    }
}
