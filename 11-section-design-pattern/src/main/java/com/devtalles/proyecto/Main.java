package com.devtalles.proyecto;

import com.devtalles.proyecto.strategy.solucion.*;

public class Main {
    public static void main(String[] args) {
        GameCharacter archer = new Archer("Legolas");
        GameCharacter mage = new Mage("Gandalf");
        GameCharacter warrior = new Warrior("Aragorn");

        archer.attack();
        mage.attack();
        warrior.attack();

        archer.setAttackStrategy(new MagicAttack());
        archer.attack();
    }
}