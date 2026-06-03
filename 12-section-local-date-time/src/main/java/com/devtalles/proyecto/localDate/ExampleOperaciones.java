package com.devtalles.proyecto.localDate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class ExampleOperaciones {
    static void main() {
//        LocalDate today = LocalDate.now();
//        LocalDate tenDaysLater = today.plusDays(10);
//        LocalDate fiveDaysBefore = today.minusDays(5);
//
//        System.out.println(today);
//        System.out.println(tenDaysLater);
//        System.out.println(fiveDaysBefore);
//
//        LocalTime now = LocalTime.now();
//        LocalTime twoHoursLater = now.plusHours(2);
//        LocalTime fiveMinutesBefore = now.minusMinutes(5);
//
//        System.out.println(now);
//        System.out.println(twoHoursLater);
//        System.out.println(fiveMinutesBefore);

//        LocalDate today = LocalDate.now();
//
//        LocalDate deliveryDate = LocalDate.of(2026,6,2);
//
//        if(today.isBefore(deliveryDate)) {
//            System.out.println("Aun no llego la fecha de entrega");
//        }else if(today.isAfter(deliveryDate)) {
//            System.out.println("Ya paso la fecha de entrega");
//        }else{
//            System.out.println("Hoy es la fecha de entrega");
//        }

//        LocalTime now = LocalTime.now();
//        LocalTime classStartTime = LocalTime.of(10,11);
//
//        if(now.isBefore(classStartTime)){
//            System.out.println("La clase todavia no empieza");
//        }else if (now.isAfter(classStartTime)){
//            System.out.println("Ya empezo o termino la clase");
//        }else {
//            System.out.println("La clase esta empezando justo ahora!");
//        }
//
//        System.out.println("Hora actual: " + now);
//        System.out.println("Hora de la clase: " + classStartTime);

//        LocalDate start = LocalDate.of(2025,12,25);
//        LocalDate end = LocalDate.of(2026,5,30);
//
//        Period diff = Period.between(start, end);
//
//        System.out.println("Diferencia: " + diff.getMonths() + " meses " + diff.getDays() + " dias");

        LocalTime start = LocalTime.of(9, 15);
        LocalTime end = LocalTime.of(14, 45);

        Duration diff = Duration.between(start, end);

        long hours = diff.toHours();
        long minutes = diff.toMinutes() % 60;

        System.out.println("Diferencia: " + hours + " horas y " + minutes + " minutos");
    }
}
