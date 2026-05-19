package com.devtalles.proyecto.encadenamientoAvanzado;

import com.devtalles.proyecto.task.student.model.Student;
import io.reactivex.rxjava3.core.Observable;

public class ChainningExample {
    static void main() {
        Observable<Student> studentObservable = Observable.just(
                new Student("Jose", 21),
                new Student("Mario", 13),
                new Student("Estela", 43)
        );

//        studentObservable.filter(student -> student.getAge() >= 21)
//                .map(student -> student.getName().toUpperCase())
//                .subscribe(System.out::println);

        studentObservable
                .filter(student -> student.getAge() >= 21)
                .flatMap(student -> getSubjectsPerStudent(student.getName()))
                .subscribe(
                        s -> System.out.println("Materia: " + s),
                        err -> System.out.println("Error: " + err.getMessage()),
                        () -> System.out.println("Fin")
                );
    }

    public static Observable<String> getSubjectsPerStudent(String name) {
        if(name.equalsIgnoreCase("Jose")){
            return Observable.just("Programación 3", "Lenguaje");
        }
        return Observable.empty();
    }
}
