package com.devtalles.proyecto.singleton.solucion;

public class Enemy {
    private final int id;

    public Enemy() {
        this.id = IDGenerator.getInstance().generateId();
    }

    public void showId(){
        System.out.println("Enemigo con ID: " + id);
    }
}
