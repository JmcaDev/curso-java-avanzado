package com.devtalles.proyecto.decorador.problema;

public class FireSword extends Sword {
    @Override
    public void attack() {
        super.attack();
        System.out.println("Daño de fuego adicional");
    }
}
