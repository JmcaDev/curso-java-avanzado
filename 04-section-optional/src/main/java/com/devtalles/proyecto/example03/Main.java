package com.devtalles.proyecto.example03;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //MAP
        Optional<String> name = Optional.of("    joSe    ");
        String nameUpperCase = name
                .map(String::trim)
                .map(String::toUpperCase)
                .orElse("Sin nombre");

        System.out.println("Nombre en mayúscula: " + nameUpperCase);

        //FlatMap
        Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.of("Valor interno"));

        Optional<String> resultFlatMap = optionalOfOptional
                .flatMap(op -> op);
        System.out.println(resultFlatMap);

        //Filter
        Optional<String> dni = Optional.of("1234567");

        Optional<String> result = dni.filter(d -> d.startsWith("2"));
        System.out.println("DNI: " + result.orElse("No válido"));

        Optional<String> email = Optional.ofNullable("        jose@jose.com    ");

        email.map(String::trim)
                .filter(e -> e.contains("@"))
                .ifPresent(m -> System.out.println("Enviando correo a: " + m));
    }
}
