package com.devtalles.proyecto.singleton.problema;

public class Player {
    private int id;

    public Player(IDGenerator idGenerator) {
        this.id = idGenerator.generateId();
    }

    public void showId(){
        System.out.println("Jugador con ID: " + id);
    }
}
