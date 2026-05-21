package com.devtalles.proyecto.student.view;

import com.devtalles.proyecto.student.controller.StudentController;

import java.util.Scanner;

public class StudentConsoleView {

    private final StudentController controller;
    private final Scanner scanner;

    public StudentConsoleView(StudentController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Si desea salir de la aplicacion ingrese 'exit'");
        while(true){
            System.out.println("Ingrese el nombre del alumno: ");
            String name = scanner.nextLine().trim();
            if(name.equalsIgnoreCase("exit")){
                controller.finishInput();
                System.out.println("Fin...");
                break;
            };

            System.out.println("Ingrese la edad del alumno: ");
            String age = scanner.nextLine().trim();

            boolean ok = controller.processInput(name, age);

            if(!ok){
                System.out.println("Edad invalidad...");
            }
        }
    }
}
