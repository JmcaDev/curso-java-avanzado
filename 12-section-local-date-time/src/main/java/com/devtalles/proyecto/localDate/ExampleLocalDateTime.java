package com.devtalles.proyecto.localDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class ExampleLocalDateTime {
    static void main() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println(today);
        System.out.println(now);
        System.out.println(currentDateTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
        System.out.println(localDateTime.format(formatter));

        localDateTime = LocalDateTime.of(2026, Month.APRIL, 24, 20,45,58);
        System.out.println(localDateTime);


        localDateTime = LocalDateTime.parse("2026-06-12T23:59:59");
        System.out.println(localDateTime);

        System.out.println(localDateTime.plusDays(1).plusHours(4));

        String format1 = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String format2 = localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"));

        System.out.println("Format1:" + format1);
        System.out.println("Format2:" + format2);
    }
}
