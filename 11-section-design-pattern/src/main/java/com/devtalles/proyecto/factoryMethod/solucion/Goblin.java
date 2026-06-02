package com.devtalles.proyecto.factoryMethod.solucion;

public class Goblin extends Enemy{

    public Goblin() {
        this.name = "Goblin";
    }

    @Override
    public void attack() {
        System.out.println(name + " lanza un ataque rapido.");
    }
}
