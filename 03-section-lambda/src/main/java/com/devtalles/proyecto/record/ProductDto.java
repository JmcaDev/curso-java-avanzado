package com.devtalles.proyecto.record;

import java.util.Objects;

public record ProductDto(String name, double price) {

    public static String ATRIBUTO ="HOLA";

    public ProductDto {
        Objects.requireNonNull(name);
    }

    public ProductDto(String name) {
        this(name, 0);
    }

    public static void methodStatic(){
        System.out.println("Metodo estatico");
    }
}
