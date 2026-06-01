package com.devtalles.proyecto.strategy.solucion;

public class MeeleAttack implements AttackStrategy{

    @Override
    public void attack(String characterName) {
        System.out.println(characterName + " ataca cuerpo a cuerpo.");
    }
}
