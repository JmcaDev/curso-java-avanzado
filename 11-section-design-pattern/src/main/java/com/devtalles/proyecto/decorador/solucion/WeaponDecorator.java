package com.devtalles.proyecto.decorador.solucion;

public abstract class WeaponDecorator implements Weapon{
    protected Weapon decoratedWeapon;

    public WeaponDecorator(Weapon decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    public void attack(){
        decoratedWeapon.attack();
    }
}
