package com.devtalles.proyecto;

import com.devtalles.proyecto.category.model.Category;
import com.devtalles.proyecto.category.persistence.CategoryDAO;
import com.devtalles.proyecto.db.ConnectionPool;
import com.devtalles.proyecto.product.controller.ProductController;
import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.repository.ProductRepositoryServices;
import com.devtalles.proyecto.product.service.ProductService;
import com.devtalles.proyecto.product.view.ProductView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try{
            System.out.println("Conexion establecida");
            CategoryDAO  categoryDAO = new CategoryDAO();
            ProductRepository productRepository = new ProductRepositoryServices(categoryDAO);
            ProductService productService = new ProductService(productRepository);
            ProductController productController = new ProductController(productService);
            ProductView productView = new ProductView(productController);
            productView.showMenu();

        } catch (SQLException | InvalidProductException e) {
            System.out.println("Error al conectar con la base de datos: "  + e.getMessage());;
        }

    }
}
