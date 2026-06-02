package com.devtalles.proyecto.observer.solucion;

public class HealthBar implements Observer{
    @Override
    public void update(int health) {
        System.out.println("Barra de salud actualizada: " + health);
    }
}
