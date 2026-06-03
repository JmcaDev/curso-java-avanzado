package com.devtalles.proyecto.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

public class Person {
    private String name;

    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    static void main() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registeredModules();

        Person person = new Person("Jose", LocalDate.of(2026,07,12));

        String json = mapper.writeValueAsString(person);
        System.out.println(json);

        String matt = """
                {
                    "name": "Matt",
                    "birthDate": "20/06/1979"
                }
                """;

        Person person1 = mapper.readValue(matt, Person.class);
        System.out.println(person1.getName());
        System.out.println(person1.getBirthDate());
    }
}
