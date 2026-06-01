package com.devtalles.proyecto.strategy.solucion;

public class BowAttack implements AttackStrategy{
    @Override
    public void attack(String characterName) {
        System.out.println(characterName + " dispara una flecha.");
    }
}
