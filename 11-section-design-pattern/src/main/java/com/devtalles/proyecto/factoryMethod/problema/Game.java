package com.devtalles.proyecto.factoryMethod.problema;

public class Game {
    public static void main(String[] args) {
        Enemy goblin = new Enemy("Goblin");
        Enemy troll = new Enemy("Troll");

        goblin.attack();
        troll.attack();
    }

}
