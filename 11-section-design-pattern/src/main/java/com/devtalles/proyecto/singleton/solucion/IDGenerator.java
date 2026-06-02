package com.devtalles.proyecto.singleton.solucion;

public class IDGenerator {
    private static IDGenerator instance;
    private int currentId;

    private IDGenerator(){};

    public static IDGenerator getInstance(){
        if(instance == null){
            instance = new IDGenerator();
        }
        return instance;
    }

    public int generateId(){
        return  ++currentId;
    }

}
