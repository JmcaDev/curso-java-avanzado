package com.devtalles.proyecto.functionalProgramming;

public class ReferencialTransparency {
    public static int triple (int x){
        return x * 3;
    }

    public static void main(String[] args){
        int resultado2 = triple(3) + 2;

        int resultado1 = 9 + 2;

        System.out.println("Resultado 1: " + resultado1);
        System.out.println("Resultado 2: " + resultado2);
    }
}
