package com.devtalles.proyecto.calendar;

import java.util.Calendar;
import java.util.Date;

public class ExampleCalendar {
    static void main() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2026);
        cal.set(Calendar.MONTH, Calendar.JUNE);
        cal.set(Calendar.DAY_OF_MONTH, 3);

        Date date = cal.getTime();
        System.out.println("Fecha: " + date);

        cal.set(Calendar.DAY_OF_MONTH, 5);
        date = cal.getTime();
        System.out.println("Fecha: " + date);
    }

}
