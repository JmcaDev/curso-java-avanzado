package com.devtalles.proyecto.localDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class LocalDateSpanish {
    static void main() {
        LocalDate date = LocalDate.now();

        Month month = date.getMonth();

        System.out.println("Número del mes: " + month.getValue());

        Locale locale = new Locale.Builder().setLanguage("es").setRegion("es").build();

        System.out.println("Mes en español: " + month.getDisplayName(TextStyle.FULL, locale));

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        System.out.println("Dia de la semana: " + dayOfWeek);

        System.out.println("Dia de la semana en español: " + dayOfWeek.getDisplayName(TextStyle.FULL, locale));

        System.out.println(month);
    }
}
