package com.devtalles.proyecto.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack <T>{
    private final List<T> elements = new ArrayList<>();

    public void push(T element){
        elements.add(element);
        System.out.println("Elemento agregado: " + element);
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }

    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("La pila esta vacia");
        }
        return elements.getLast();
    }

    public T pop(){
        if(isEmpty()){
            throw new IllegalStateException("La pila esta vacia");
        }
        return elements.removeLast();
    }

    public void print(){
        if(isEmpty()){
            throw new IllegalStateException("La pila esta vacia");
        }

        for(Object o: elements){
            System.out.println(o);
        }
    }
}
