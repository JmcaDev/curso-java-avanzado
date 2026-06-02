package com.devtalles.proyecto.decorador.solucion;

public class Game {
    public static void main(String[] args) {
        Weapon sword = new Sword();
        sword.attack();

        System.out.println("------------------------");

        Weapon fireSword = new FireDecorator(sword);
        fireSword.attack();

        System.out.println("------------------------");
        Weapon poisonSword = new PoisonDecorator(sword);
        poisonSword.attack();

        System.out.println("------------------------");
        Weapon deadlySword = new FireDecorator(poisonSword);
        deadlySword.attack();

    }
}
