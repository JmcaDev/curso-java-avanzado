package com.devtalles.proyecto.factoryMethod.problema;

public class Enemy {
    protected  String name;

    public Enemy(String name) {
        this.name = name;
    }

    public void attack(){
        System.out.println(name + " ataca ferozmente.");
    }
}
