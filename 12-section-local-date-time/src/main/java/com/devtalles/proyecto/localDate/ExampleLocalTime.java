package com.devtalles.proyecto.localDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ExampleLocalTime {
    static void main() {
        LocalTime now = LocalTime.now();

        System.out.println("Hora: " + now.getHour());
        System.out.println("Minutos: " + now.getMinute());
        System.out.println("Seg: " + now.getSecond());

        LocalTime coffeeBreak = LocalTime.of(13,30);

        System.out.println(coffeeBreak);

        System.out.println("Suma: " + coffeeBreak.plus(1, ChronoUnit.HOURS));
        System.out.println("Suma: " + coffeeBreak.plusHours(1));
        System.out.println("Resta: " + coffeeBreak.minus(1, ChronoUnit.HOURS));
        System.out.println("Resta: " + coffeeBreak.minusHours(1));

        System.out.println(LocalTime.of(7,40).isBefore(LocalTime.parse("08:30")));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        String time = now.format(dateTimeFormatter);
        System.out.println(time);

        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;
        LocalTime midnight = LocalTime.MIDNIGHT;

        System.out.println(max);
        System.out.println(min);
        System.out.println(midnight);
    }
}
