package com.devtalles.proyecto.factoryMethod.solucion;

public class Dragon extends Enemy{

    public Dragon() {
        this.name = "Dragon";
    }

    @Override
    public void attack() {
        System.out.println(name + " Escupe fuego desde lo alto.");
    }
}
