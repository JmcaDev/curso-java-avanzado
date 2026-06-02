package com.devtalles.proyecto.singleton.solucion;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Enemy enemy = new Enemy();
        Enemy enemy2 = new Enemy();
        Enemy enemy3 = new Enemy();

        player.showId();
        player2.showId();
        player3.showId();
        enemy.showId();
        enemy2.showId();
        enemy3.showId();
    }
}
