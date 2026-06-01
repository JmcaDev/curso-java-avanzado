package com.devtalles.proyecto.strategy.problema;

public class Mage {
    private String name;

    public Mage(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println(name + " lanza un hechizo.");
    }
}
