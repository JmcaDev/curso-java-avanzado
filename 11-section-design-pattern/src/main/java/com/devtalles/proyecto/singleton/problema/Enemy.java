package com.devtalles.proyecto.singleton.problema;

public class Enemy {
    private int id;

    public Enemy(IDGenerator idGenerator){
        this.id = idGenerator.generateId();
    }

    public void showId(){
        System.out.println("Enemigo con ID: " + id);
    }
}
