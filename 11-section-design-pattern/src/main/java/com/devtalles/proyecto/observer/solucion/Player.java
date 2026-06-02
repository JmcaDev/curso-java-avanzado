package com.devtalles.proyecto.observer.solucion;

import java.util.ArrayList;
import java.util.List;

public class Player implements Subject{
    private int health = 100;
    private List<Observer> observers = new ArrayList<>();

    public void takeDamage(int damage){
        this.health -= damage;
        System.out.println("El jugador recibio " + damage + " de daño. Salud actual: " + health);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(health);
        }
    }
}
