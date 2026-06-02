package com.devtalles.proyecto.factoryMethod.solucion;

public class GoblinFactory extends EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new Goblin();
    }
}
