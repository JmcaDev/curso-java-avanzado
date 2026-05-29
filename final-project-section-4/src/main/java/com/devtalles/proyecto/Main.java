package com.devtalles.proyecto;

import com.devtalles.proyecto.db.ConnectionPool;
import com.devtalles.proyecto.product.controller.ProductController;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.repository.ProductRepositoryServices;
import com.devtalles.proyecto.product.service.ProductService;
import com.devtalles.proyecto.product.view.ProductView;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try(Connection connection = ConnectionPool.getConnection()){
            System.out.println("Conexion establecida");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: "  + e.getMessage());;
        }finally {
            try {
                ConnectionPool.closePool();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion con la base de datos: "  + e.getMessage());;
            }
        }

//        ProductRepository productRepository = new ProductRepositoryServices();
//        ProductService productService = new ProductService(productRepository);
//        ProductController productController = new ProductController(productService);
//        ProductView productView = new ProductView(productController);
//
//        productView.showMenu();
    }
}
