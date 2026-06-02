package com.devtalles.proyecto.command.solucion;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
        System.out.println("Jugador " + name + " creado.");
    }

    public void attack(){
        System.out.println(name + " ataca con su espada.");
    }

    public void defend(){
        System.out.println(name + " se defiende con su escudo.");
    }

    public void useItem(){
        System.out.println(name + " usa una pocion de vida.");
    }

    public void run(){
        System.out.println(name + " corre a gran velocidad");
    }
}
