package com.devtalles.proyecto.builder.solucion;

public class GameCharacter {
    private String name;
    private String type;

    public GameCharacter(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
    }

    public void showStats(){
        System.out.println("Personaje: "+(name != null ? name : "Sin nombre"));
        System.out.println("Clase: "+(type  != null ? type : "Clase no asignada"));
    }

    public static class Builder{
        private String name;
        private String type;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withType(String type){
            this.type = type;
            return this;
        }

        public GameCharacter build(){
            return new GameCharacter(this);
        }
    }
}
