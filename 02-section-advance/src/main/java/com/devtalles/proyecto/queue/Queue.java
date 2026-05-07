package com.devtalles.proyecto.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue <T>{
    private final LinkedList<T> elements = new LinkedList<>();

    //Ingresa al Queue
    public void enQueue(T element){
        elements.addLast(element);
        System.out.println("Elemento agregado: " + element);
    }


    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("La Cola esta vacia");
        }
        return elements.getFirst();
    }

    //Sale del Queue
    public T deQueue(){
        if(isEmpty()){
            throw new NoSuchElementException("La Cola esta vacia");
        }
        return elements.removeFirst();
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }

    public void print(){
        for (Object o : elements){
            System.out.println(o);
        }
    }
}
