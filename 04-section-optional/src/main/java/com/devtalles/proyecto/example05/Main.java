package com.devtalles.proyecto.example05;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //Ejemplo 4
        String maybeName = "Jose";

        Optional.ofNullable(maybeName)
                .ifPresentOrElse(
                        name -> System.out.println("Nombre encontrado: " + name.toUpperCase()),
                        () -> System.out.println("Nombre no encontrado")
                );

        //Ejemplo 5
        List<Optional<String>> optionals = List.of(
                Optional.of("Hola"),
                Optional.empty(),
                Optional.of("Chao")
        );

        optionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}
