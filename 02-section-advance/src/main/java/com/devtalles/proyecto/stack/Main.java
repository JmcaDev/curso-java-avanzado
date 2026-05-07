package com.devtalles.proyecto.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);

        Stack<String> names = new Stack<>();

        names.push("Jose");
        names.push("Miguel");
        names.push("Castillo");

        System.out.println("Elemento en la cima: " + integerStack.peek());
        System.out.println("Elemento en la cima: " + names.peek());

        System.out.println("Eliminar un elemento: " + integerStack.pop());
        System.out.println("Eliminar un elemento: " + names.pop());

        integerStack.print();
        names.print();
    }
}
