package com.devtalles.proyecto.strategy.solucion;

public class MagicAttack implements AttackStrategy{
    @Override
    public void attack(String characterName) {
        System.out.println(characterName + " lanza un hechizo.");
    }
}
