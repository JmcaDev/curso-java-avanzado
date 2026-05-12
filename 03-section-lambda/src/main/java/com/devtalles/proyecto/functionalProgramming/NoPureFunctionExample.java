package com.devtalles.proyecto.functionalProgramming;

public class NoPureFunctionExample {

    static int contador = 0; //Estado compartido (efecto colateral)

    public static int incrementCounter(int valor){
        contador += valor; // Modifica estado global
        return contador;
    }

    public static void main(String[] args){
        System.out.println("Resultado 1: " + incrementCounter(5)); // Resultado 1: 5
        System.out.println("Resultado 2: " + incrementCounter(5)); // Resultado 2: 10
    }

}
