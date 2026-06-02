package com.devtalles.proyecto.factoryMethod.solucion;

public class DragonFactory extends EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new Dragon();
    }
}
