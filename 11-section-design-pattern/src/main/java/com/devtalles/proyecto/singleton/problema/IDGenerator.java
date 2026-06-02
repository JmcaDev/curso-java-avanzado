package com.devtalles.proyecto.singleton.problema;

public class IDGenerator {
    private int currentId = 0;

    public int generateId() {
        return ++currentId;
    }

}
