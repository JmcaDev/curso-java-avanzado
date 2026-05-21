package com.devtalles.proyecto.student;

import com.devtalles.proyecto.student.controller.StudentController;
import com.devtalles.proyecto.student.service.StudentService;
import com.devtalles.proyecto.student.stream.StudentStream;
import com.devtalles.proyecto.student.view.StudentConsoleView;
//import com.devtalles.proyecto.task.student.model.Student;

public class App {
    static void main() {

//        stream.getStream().subscribe(
//                item -> System.out.println(item),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Fin")
//        );
//
//        stream.publish(new Student("Jose", 25));
//        stream.publish(new Student("Gabriel", 33));
//
//        stream.complete();
        StudentStream stream = new StudentStream();
        StudentService service = new StudentService();
        StudentController controller = new StudentController(stream, service);
        StudentConsoleView view = new StudentConsoleView(controller);
        view.start();
    }
}
