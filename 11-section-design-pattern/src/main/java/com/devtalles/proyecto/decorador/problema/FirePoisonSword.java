package com.devtalles.proyecto.decorador.problema;

public class FirePoisonSword extends Sword{
    @Override
    public void attack() {
        super.attack();
        System.out.println("Daño de fuego adicional");
        System.out.println("Daño de veneno adicional");
    }
}
