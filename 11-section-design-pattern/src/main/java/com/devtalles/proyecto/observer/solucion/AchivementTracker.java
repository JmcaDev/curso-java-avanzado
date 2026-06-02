package com.devtalles.proyecto.observer.solucion;

public class AchivementTracker implements Observer{
    @Override
    public void update(int health) {
        if(health < 50){
            System.out.println("Logro desbloqueado: ¡Estas herido, pero sigues en pie!");
        }
    }
}
