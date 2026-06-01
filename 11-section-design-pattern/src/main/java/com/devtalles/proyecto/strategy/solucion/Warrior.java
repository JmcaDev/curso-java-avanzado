package com.devtalles.proyecto.strategy.solucion;

public class Warrior extends GameCharacter {
    private String name;

    public Warrior(String name) {
        super(name);
        this.attackStrategy = new MeeleAttack();
    }
}
