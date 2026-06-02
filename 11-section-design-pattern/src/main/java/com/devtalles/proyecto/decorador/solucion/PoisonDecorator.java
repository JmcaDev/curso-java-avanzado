package com.devtalles.proyecto.decorador.solucion;

public class PoisonDecorator extends WeaponDecorator{

    public PoisonDecorator(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public void attack(){
        super.attack();
        System.out.println("Daño adicional de veneno");
    }
}
