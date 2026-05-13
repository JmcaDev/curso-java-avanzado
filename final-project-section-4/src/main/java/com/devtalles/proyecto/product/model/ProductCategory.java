package com.devtalles.proyecto.product.model;

public enum ProductCategory {
    ELECTRÓNICOS, COMIDAS, LIBROS, OTROS;

    public static boolean isValid(String input){
        for (ProductCategory productCategory : ProductCategory.values()){
            if(productCategory.name().equals(input)){
                return true;
            }
        }
        return false;
    }
}
