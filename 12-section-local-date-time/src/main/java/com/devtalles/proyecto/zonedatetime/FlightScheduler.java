package com.devtalles.proyecto.zonedatetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FlightScheduler {
    static void main() {
        ZoneId departureZone = ZoneId.of("Europe/Madrid");
        ZoneId arrivalZone =  ZoneId.of("America/Caracas");

        ZonedDateTime departureTime = ZonedDateTime.now(departureZone).plusHours(5);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a z");

        System.out.println("Hora de salida de madrid: " + departureTime.format(formatter));

        ZonedDateTime arrivalTime = departureTime.plusHours(10).withZoneSameInstant(arrivalZone);
        System.out.println("Hora de llegada a Caracas: " + arrivalTime.format(formatter));
    }
}
