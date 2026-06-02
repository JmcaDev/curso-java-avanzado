package com.devtalles.proyecto.observer.problema;

public class Player {
    private int health;

    public Player() {
        this.health = 100;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println("El jugador recibio " + damage + " de daño. Salud actual: " + health);

        //Notificar directamente cada componente
        updateHealthBar();
        logDamage();
        checkAchievements();
    }

    private void updateHealthBar(){
        System.out.println("Barra de salud actualizada: " + health);
    }

    private void logDamage(){
        System.out.println("Registro: saludo del jugador = " + health);
    }

    private void checkAchievements(){
        if(health < 50){
            System.out.println("Logro desbloqueado: ¡Estas herido, pero sigues en pie!");
        }
    }
}
