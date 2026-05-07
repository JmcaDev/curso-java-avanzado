package com.devtalles.proyecto.queue;

public class Main {
    public static void main(String[] args){
        Queue<Integer> numbers = new Queue<>();

        numbers.enQueue(10);
        numbers.enQueue(20);
        numbers.enQueue(30);

        numbers.print();

        System.out.println("Ver primero de la cola: " + numbers.peek());
        System.out.println("Eliminar el primero de la cola: " + numbers.deQueue());

        numbers.print();
        System.out.println("---------------------------");
        Queue<String> names = new Queue<>();

        names.enQueue("Jose");
        names.enQueue("Miguel");
        names.enQueue("Castillo");

        names.print();

        System.out.println("Ver primero de la cola: " + names.peek());
        System.out.println("Eliminar el primero de la cola: " + names.deQueue());

        names.print();
    }
}
