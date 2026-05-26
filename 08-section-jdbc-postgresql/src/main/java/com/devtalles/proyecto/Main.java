package com.devtalles.proyecto;

import com.devtalles.proyecto.category.Category;
import com.devtalles.proyecto.db.ConnectionDB;
import com.devtalles.proyecto.db.DataBaseConnection;
import com.devtalles.proyecto.product.Product;
import com.devtalles.proyecto.product.ProductDAO;
import com.devtalles.proyecto.product.ProductDAODos;
import com.devtalles.proyecto.product.ProductService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        ProductService service = new ProductService();


        Product product = new Product("Notebook3", 1200, 20);
        Category category = new Category("Tecnologia2".trim().toUpperCase());

        try{
            //Agregar producto
            service.saveProductWithCategory(product, category);

            //Listar productos
            List<Product> products = service.findProducts();
            products.forEach(System.out::println);

            System.out.println("------------------------");

            //Eliminar productos
            service.deleteProduct(4L);
            List<Product> products2 = service.findProducts();
            products2.forEach(System.out::println);

            System.out.println("------------------------");

            //Actualizar producto
            Product product2 = new Product(5L,"Luna de pluton", 1200, 20);
            Category category2 = new Category(4L,"Libros".trim().toUpperCase());

            service.updateProduct(product2, category2);

        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }


    }
}