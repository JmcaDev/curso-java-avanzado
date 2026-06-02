package com.devtalles.proyecto.builder.solucion;

public class GameCharacter {
    private String name;
    private String type;

    public GameCharacter(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void showStats(){
        System.out.println("Personaje: "+name);
        System.out.println("Clase: "+type);
    }

    public static class Builder{
        private String name;
        private String type;

        public Builder withName(String name){

        }
    }
}
