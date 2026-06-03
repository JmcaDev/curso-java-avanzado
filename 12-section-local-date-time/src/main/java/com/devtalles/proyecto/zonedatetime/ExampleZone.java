package com.devtalles.proyecto.zonedatetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ExampleZone {
    static void main() {
//        ZoneId.getAvailableZoneIds().stream()
//                .sorted()
//                .forEach(System.out::println);
//
//        ZoneId.getAvailableZoneIds().stream()
//                .filter( id -> id.toLowerCase().contains("america"))
//                .sorted()
//                .forEach(System.out::println);

//        ZoneId caracas = ZoneId.of("America/Caracas");
//
//        ZonedDateTime nowCaracas = ZonedDateTime.now(caracas);
//        System.out.println("Tiempo en caracas:" + nowCaracas);
//
//        ZonedDateTime madrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
//        System.out.println("Tiempo en madrid:" + madrid);

        ZoneId caracas = ZoneId.of("America/Caracas");

        ZonedDateTime nowCaracas = ZonedDateTime.of(2025,6,23,15,30,0,0, caracas);
        ZonedDateTime madrid = nowCaracas.withZoneSameInstant((ZoneId.of("Europe/Madrid")));

        System.out.println("Tiempo en caracas:" + nowCaracas);
        System.out.println("Tiempo en madrid:" + madrid);
    }
}
