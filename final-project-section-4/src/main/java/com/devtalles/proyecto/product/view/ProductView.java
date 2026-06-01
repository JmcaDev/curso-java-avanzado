package com.devtalles.proyecto.product.view;

import com.devtalles.proyecto.category.model.Category;
import com.devtalles.proyecto.product.controller.ProductController;
import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.exceptions.ProductNotFoundException;
import com.devtalles.proyecto.product.model.Product;
import com.devtalles.proyecto.product.model.ProductCategory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductView {
    private final ProductController productController;
    private final Scanner scanner;

    public ProductView(ProductController productController) {
        this.productController = productController;
        scanner = new Scanner(System.in);
    }

    public void showMenu(){
        while(true){
            System.out.println("\nSeleccione una opción: ");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Eliminar producto por ID");
            System.out.println("5. Modificar producto por ID");
            System.out.println("6. Salir");
            System.out.println("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1 -> addProduct();
                case 2 -> showAllProducts();
                case 3 -> findProductById();
                case 4 -> deleteProductById();
                case 5 -> updateProduct();
                case 6 -> {
                    scanner.close();
                    return;
                }
            }

        }
    }

    private void addProduct(){
        try {
            String productName = readNonEmptyString("Ingrese el nombre del producto: ");
            double productPrice = readValidDouble("Ingrese el precio del producto: ", 1);
            int productStock = readValidInteger("Ingrese el stock del producto: ", 1);
            String categoryName = readNonEmptyString("Ingrese el nombre de la categoria: ");
            Category category = new Category(categoryName.trim().toUpperCase());
            Product product = new Product(productName, productPrice, productStock, category);
            productController.addProduct(product);

        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("La categoria no existe");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllProducts(){
        try {
            List<Product> products = productController.getAllProducts();
            products.forEach(this::showProduct);
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void findProductById(){
        try {
            long id = readValidLong("Ingrese el ID del producto: ", 0);
            Optional<Product> product = productController.getProductById(id);
            if(product.isPresent()){
                Product product1 = product.get();
                showProduct(product1);
            }else{
                System.out.println("El producto no se encuentra en la BD");
            }
        } catch (ProductNotFoundException | InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteProductById(){
        try {
            long id = readValidLong("Ingrese el ID del producto: ", 0);
            productController.removeProduct(id);
        }catch (ProductNotFoundException | InvalidProductException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateProduct(){
        try {
            long id = readValidLong("Ingrese el ID del producto: ", 0);
            Optional<Product> product = productController.getProductByIdDB(id);
            if(product.isPresent()){
                System.out.println("Producto a MODIFICAR");
                Product product1 = product.get();
                showProduct(product1);
                System.out.println("Seleccione el campo que desea modificar");
                System.out.println("1. Nombre del producto");
                System.out.println("2. Precio del producto");
                System.out.println("3. Stock del producto");
                System.out.println("4. Categoria del producto");
                System.out.println("5. TODOS");
                System.out.println("6. Salir");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch(option){
                    case 1 -> product.get().setName(readNonEmptyString("Ingrese el nuevo nombre del producto: "));
                    case 2 -> product.get().setPrice(readValidDouble("Ingrese el nuevo precio del producto: ", 1));
                    case 3 -> product.get().setStock(readValidInteger("Ingrese el nuevo stock del producto: ", 1));
                    case 4 -> {
                        String categoryName = readNonEmptyString("Ingrese el nombre de la categoria: ");
                        Category category = new Category(categoryName.trim().toUpperCase());
                        product.get().setCategory(category);
                    }
                    case 5 -> {
                        product.get().setName(readNonEmptyString("Ingrese el nuevo nombre del producto: "));
                        product.get().setPrice(readValidDouble("Ingrese el nuevo precio del producto: ", 1));
                        product.get().setStock(readValidInteger("Ingrese el nuevo stock del producto: ", 1));
                        String categoryName = readNonEmptyString("Ingrese el nombre de la categoria: ");
                        Category category = new Category(categoryName.trim().toUpperCase());
                        product.get().setCategory(category);
                    }
                    case 6 -> {
                        return;
                    }
                }
                productController.updateProduct(product1);
            }else{
                System.out.println("El producto no se encuentra en la BD");
            }
        } catch (ProductNotFoundException | InvalidProductException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void showProduct(Product product){
        System.out.println("\nProducto: ");
        System.out.println("ID: " + product.getId());
        System.out.println("Nombre: " + product.getName());
        System.out.println("Precio: " + product.getPrice() + "$");
        System.out.println("Stock: " + product.getStock() + " und");
        System.out.println("Categoria: " + product.getCategory());
        System.out.println("--------------------------------------");
    }

    private String readNonEmptyString(String message) {
        String input;
        do{
            System.out.println(message);
            input = scanner.nextLine().trim();
            if(input.length() < 2){
                System.out.println("El valor no puede ser vació o el nombre es muy corto");
            }
        }while(input.length() < 2);
        return input;
    }

    private String readValidCategory(String message) {
        String input;
        do{
            System.out.println(message);
            input = scanner.nextLine().trim().toUpperCase();
            if(!ProductCategory.isValid(input)){
                System.out.println("La categoria es invalidad");
            }
        }while(!ProductCategory.isValid(input));
        return input;
    }

    private Long readValidLong(String message, long min) {
        Long value;
        do{
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try{
                value = Long.parseLong(input);
                if(value < min){
                    System.out.println("El valor debe ser mayor a: " +min);
                    continue;
                }
                return value;
            }catch (NumberFormatException e){
                System.out.println("Error: " + e.getMessage());
            }

        }while (true);
    }

    private int readValidInteger(String message, long min) {
        int value;
        do{
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try{
                value = Integer.parseInt(input);
                if(value < min){
                    System.out.println("El valor debe ser mayor a: " +min);
                    continue;
                }
                return value;
            }catch (NumberFormatException e){
                System.out.println("Error: " + e.getMessage());
            }

        }while (true);
    }

    private double readValidDouble(String message, long min) {
        double value;
        do{
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try{
                value = Double.parseDouble(input);
                if(value < min){
                    System.out.println("El valor debe ser mayor a: " +min);
                    continue;
                }
                return value;
            }catch (NumberFormatException e){
                System.out.println("Error: " + e.getMessage());
            }

        }while (true);
    }
}
