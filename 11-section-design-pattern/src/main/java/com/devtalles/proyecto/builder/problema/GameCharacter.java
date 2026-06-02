package com.devtalles.proyecto.builder.problema;

public class GameCharacter {
    private String name;
    private String type;
    private int level;
    private int Strength;
    private int defense;
    private int magic;
    private int speed;
    private int agility;
    private int experience;

    public GameCharacter(String name, String type, int level, int strength, int defense, int magic, int speed, int agility, int experience) {
        this.name = name;
        this.type = type;
        this.level = level;
        Strength = strength;
        this.defense = defense;
        this.magic = magic;
        this.speed = speed;
        this.agility = agility;
        this.experience = experience;
    }
}
