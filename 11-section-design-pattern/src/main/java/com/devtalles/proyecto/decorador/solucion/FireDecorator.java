package com.devtalles.proyecto.decorador.solucion;

public class FireDecorator extends WeaponDecorator{

    public FireDecorator(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public void attack(){
        super.attack();
        System.out.println("Daño de fuego adicional");
    }
}
