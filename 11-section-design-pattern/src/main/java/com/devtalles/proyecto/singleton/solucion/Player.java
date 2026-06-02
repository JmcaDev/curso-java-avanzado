package com.devtalles.proyecto.singleton.solucion;

public class Player {
    private final int id;

    public Player() {
        this.id = IDGenerator.getInstance().generateId();
    }

    public void showId(){
        System.out.println("Jugador con ID: " + id);
    }
}
