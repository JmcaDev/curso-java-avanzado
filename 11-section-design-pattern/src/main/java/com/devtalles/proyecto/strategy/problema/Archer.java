package com.devtalles.proyecto.strategy.problema;

public class Archer {
    private String name;

    public Archer(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println(name + " dispara una flecha.");
    }
}
