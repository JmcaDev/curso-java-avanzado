package com.devtalles.proyecto.factoryMethod.solucion;

public class Game {
    public static void main(String[] args) {
        EnemyFactory goblinFactory = new GoblinFactory();
        EnemyFactory trollFactory = new TrollFactory();
        EnemyFactory dragonFactory = new DragonFactory();

        Enemy goblin = goblinFactory.createEnemy();
        Enemy troll = trollFactory.createEnemy();
        Enemy dragon = dragonFactory.createEnemy();

        goblin.attack();
        troll.attack();
        dragon.attack();
    }
}
