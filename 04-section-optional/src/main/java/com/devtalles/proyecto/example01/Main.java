package com.devtalles.proyecto.example01;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<String> name = Optional.of("Jose");

        if(name.isPresent()){
            System.out.println("El nombre esta presente");
        }

        String value = "Miguel";

        Optional<String> nick = Optional.ofNullable(value);
        Optional<String> empty = Optional.empty();

        if(nick.isPresent()){
            System.out.println("El nombre esta presente");
        }else{
            System.out.println("Vacio");
        }

        if(empty.isPresent()){
            System.out.println("El nombre esta presente");
        }else{
            System.out.println("Vacio");
        }

        Optional<String> greeding = Optional.of("Hola mundo");

        greeding.ifPresent( message -> System.out.println(message));
    }
}
