package com.devtalles.proyecto.builder.solucion;

public class Outer {
    static class Inner {
        void show(){
            System.out.println("Soy una clase interna y estatica");
        }
    }

    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner();
        obj.show();
    }
}
