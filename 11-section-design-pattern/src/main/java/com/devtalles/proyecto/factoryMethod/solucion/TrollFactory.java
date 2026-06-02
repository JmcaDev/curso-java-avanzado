package com.devtalles.proyecto.factoryMethod.solucion;

public class TrollFactory extends EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new Troll();
    }
}
