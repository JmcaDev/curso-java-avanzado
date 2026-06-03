package com.devtalles.proyecto.localDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ExampleLocalDateTime {
    static void main() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println(today);
        System.out.println(now);
        System.out.println(currentDateTime);
    }
}
