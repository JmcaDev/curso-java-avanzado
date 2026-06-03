package com.devtalles.proyecto.localDate;

import java.time.LocalDate;

public class ExampleLocalDate {
    static void main() {
        LocalDate date = LocalDate.of(2026,6,3);
        System.out.println("Fecha Original: " + date);

        LocalDate updateDate = date.plusDays(5);
        System.out.println("Fecha modificada: " + updateDate);

        System.out.println("Fecha Original: " + date);
    }
}
