package com.devtalles.proyecto.example02;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Ingrese el nombre del usuario: ");
//        String name = input.nextLine();
//
//        Optional<String> optionalName = Optional.empty();
//
//        if(name.isEmpty()){
//            name = optionalName.orElse("Invitado");
//        }
//        System.out.println(name);

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el nombre del usuario: ");
        String nameInput = input.nextLine();

        Optional<String> optional = Optional.ofNullable(nameInput)
                .filter(name -> !name.isEmpty());
        String name = optional.orElseGet(() -> "Invitado");

        System.out.println(name);

        input.close();


    }
}
