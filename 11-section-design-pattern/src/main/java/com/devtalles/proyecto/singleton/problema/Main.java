package com.devtalles.proyecto.singleton.problema;

public class Main {
    public static void main(String[] args) {
        IDGenerator gen1 = new IDGenerator();
        IDGenerator gen2 = new IDGenerator();

        Player player = new Player(gen1);
        Enemy enemy = new Enemy(gen2);

        player.showId();
        enemy.showId();
    }
}
