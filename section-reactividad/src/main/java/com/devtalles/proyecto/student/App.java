package com.devtalles.proyecto.student;

import com.devtalles.proyecto.student.stream.StudentStream;
import com.devtalles.proyecto.task.student.model.Student;

public class App {
    static void main() {
        StudentStream stream = new StudentStream();

        stream.getStream().subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Fin")
        );

        stream.publish(new Student("Jose", 25));
        stream.publish(new Student("Gabriel", 33));

        stream.complete();
    }
}
