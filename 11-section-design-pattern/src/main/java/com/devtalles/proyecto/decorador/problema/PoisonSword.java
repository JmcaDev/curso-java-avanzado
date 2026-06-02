package com.devtalles.proyecto.decorador.problema;

public class PoisonSword extends Sword{
    @Override
    public void attack() {
        super.attack();
        System.out.println("Daño de veneno adicional");
    }
}
