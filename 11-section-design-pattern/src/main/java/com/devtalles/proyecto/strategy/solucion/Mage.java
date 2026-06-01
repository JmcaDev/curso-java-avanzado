package com.devtalles.proyecto.strategy.solucion;

public class Mage extends GameCharacter {
    private String name;

    public Mage(String name) {
        super(name);
        this.attackStrategy = new MagicAttack();
    }
}
