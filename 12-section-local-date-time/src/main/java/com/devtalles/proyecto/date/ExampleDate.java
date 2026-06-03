package com.devtalles.proyecto.date;

import java.util.Date;

public class ExampleDate {
    static void main() {
        Date date = new Date();
        System.out.println("Fecha Original: " + date);

        date.setTime(0);
        System.out.println("Fecha modificada: " + date);
    }
}
