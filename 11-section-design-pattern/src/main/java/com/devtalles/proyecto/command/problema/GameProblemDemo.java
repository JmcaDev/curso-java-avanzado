package com.devtalles.proyecto.command.problema;

import java.util.Scanner;

public class GameProblemDemo {
    public static void main(String[] args) {
        Player player = new Player("Jose el programador");
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- DEMOSTRACION DEL PROBLEMA (Acoplamiento directo) ---");
        System.out.println("Comandos: A (Atacar), D (Defender), I (Item), R (Correr). Escribe 'salir' para terminar el demo");

        while (true){
            System.out.println("Ingrese una opcion: ");
            String input = scanner.nextLine().toUpperCase();

            if(input.equals("SALIR")){
                break;
            }

            if (input.equals("A")){
                player.attack();
            } else if(input.equals("D")){
                player.defend();
            } else if(input.equals("I")){
                player.useItem();
            } else if (input.equals("R")) {
                player.run();
            }else{
                System.out.println("Comando invalido: " + input);
            }
            System.out.println("--------------------------------");
        }
    }
}
