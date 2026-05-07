package com.devtalles.proyecto.datastore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStore<User, String> userStore = new DataStore<>();

        try {
            System.out.println("Añadiendo usuarios...");
            userStore.add("123", new User("123", "Jose"));
            userStore.add("456", new User("456", "Miguel"));
            userStore.add("789", new User("789", "Castillo"));
            //userStore.add(null, new User("789", "Castillo"));

            System.out.println("Encontrado: " +userStore.find("789"));
            System.out.println("Eliminado: " +userStore.remove("789"));

        }catch (NullPointerException e){
            System.out.println("Error: " + e.getMessage());
        }

        List<User> users = userStore.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
