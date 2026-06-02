package com.devtalles.proyecto.observer.solucion;

public class Game {
    public static void main(String[] args) {
        Player player = new Player();

        player.addObserver(new HealthBar());
        player.addObserver(new GameLogger());
        player.addObserver(new AchivementTracker());

        player.takeDamage(20);
        player.takeDamage(40);
    }
}
