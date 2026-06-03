package com.devtalles.proyecto.postgress;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    static void main() {
        PersonService personService = new PersonService();
        //Person person = new Person("Jose", LocalDate.of(2000,7,12));

        try{
           Person person = personService.findPersonById(1);
            System.out.println(person);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());;
        }
    }
}
