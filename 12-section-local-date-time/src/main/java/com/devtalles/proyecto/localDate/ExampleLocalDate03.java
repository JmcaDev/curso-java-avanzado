package com.devtalles.proyecto.localDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ExampleLocalDate03 {
    static void main() {
//        LocalDate date = LocalDate.of(2025,6,10);
//        System.out.println(date);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        String formattedDate = date.format(formatter);
//        System.out.println(formattedDate);

//        String dateText = "12/07/2026";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        LocalDate parsedDate = LocalDate.parse(dateText, formatter);
//        System.out.println(parsedDate);

        try {
            String dateText = "dom 12 julio 2026";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd MMMM yyyy");

            LocalDate parsedDate = LocalDate.parse(dateText, formatter);
            System.out.println(parsedDate.format(formatter));
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
