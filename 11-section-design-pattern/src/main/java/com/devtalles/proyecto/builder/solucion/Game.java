package com.devtalles.proyecto.builder.solucion;

public class Game {
    public static void main(String[] args) {
        GameCharacter mage = new GameCharacter
                .Builder()
                .withName("Jose")
                .build();

        mage.showStats();
    }
}
