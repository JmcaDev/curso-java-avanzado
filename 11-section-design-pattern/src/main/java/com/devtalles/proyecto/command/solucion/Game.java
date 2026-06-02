package com.devtalles.proyecto.command.solucion;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player player = new Player("Jose el programador");

        Command attack = new AttackCommand(player);
        Command defend = new DefendCommand(player);

        InputHandler inputHandler = new InputHandler();

        inputHandler.bind("A", attack);
        inputHandler.bind("D", defend);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- DEMOSTRACION DEL PATRON COMMAND CON UNDO ---");
        System.out.println("Comandos: A (Atacar), D (Defender).");
        System.out.println("Escribe 'U' para deshacer la ultima accion.");
        System.out.println("Escribe 'SALIR' para terminar.");

        while(true){
            System.out.println("Ingresa una accion: ");
            String input = scanner.nextLine().toUpperCase();

            if(input.equals("SALIR")){
                break;
            }

            if(input.equals("U")){
                inputHandler.undoLastCommand();
            } else{
                inputHandler.handleInput(input);
            }
            System.out.println("--------------------------------------");
        }
        scanner.close();
        System.out.println("FIN DEL DEMO");
    }
}
