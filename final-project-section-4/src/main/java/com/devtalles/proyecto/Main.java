package com.devtalles.proyecto;

import com.devtalles.proyecto.category.model.Category;
import com.devtalles.proyecto.category.persistence.CategoryDAO;
import com.devtalles.proyecto.db.ConnectionPool;
import com.devtalles.proyecto.product.controller.ProductController;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.repository.ProductRepositoryServices;
import com.devtalles.proyecto.product.service.ProductService;
import com.devtalles.proyecto.product.view.ProductView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try(Connection connection = ConnectionPool.getConnection()){
            System.out.println("Conexion establecida");

            // -- Prueba del Category DAO ---
            CategoryDAO  categoryDAO = new CategoryDAO(connection);

            System.out.println("\n--- Probando CategoryDAO ---");

            // 1. Guardando Categorias
            System.out.println("--- Guardando Categorías ---");

            Category comidas = new Category(null, "Comidas");
            Category libros = new Category(null, "Libros");
            Category tecnologias = new Category(null, "Tecnologias");

            categoryDAO.save(comidas);
            categoryDAO.save(libros);
            categoryDAO.save(tecnologias);

            // 2. Listar todas las categorias
            System.out.println("\nListando todas las categorías: ");
            List<Category> allCategories = categoryDAO.findAll();
            allCategories.forEach(System.out::println);

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
