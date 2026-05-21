package com.devtalles.proyecto.student.service;

import com.devtalles.proyecto.task.student.model.Student;
import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void subscribeTo(Observable<Student> stream){
        stream.subscribe(
                student -> {
                    System.out.println("Agregando estudiante: " + student);
                    students.add(student);
                },
                error -> System.out.println("Error: " + error.getMessage()),
                () -> {
                    System.out.println("Stream completo. Estudiante agregado...");
                    students.forEach(System.out::println);
                    showStadistics();
                }
        );
    }

    private void showStadistics(){
        System.out.println("Estadisticas");
        System.out.println("Total: " + students.size());

        if(!students.isEmpty()){
            double ageAverage = students.stream()
                    .mapToInt(Student::getAge)
                    .average()
                    .orElse(0.0);
            System.out.println("Promedio de edad: " + ageAverage);
        }
    }

    public Observable<Student> verifyStudent(Student student){
        return Observable.create(emitter -> {
            System.out.println("Verificando la edad del estudiante: " + student.getName());
            Thread.sleep(1000);

            if(student.getAge() >= 18){
                emitter.onNext(student);
            }else{
                System.out.println("Estudiante es menor de edad..." + student.getName());
            }

            emitter.onComplete();
        });
    }

    public Observable<Student> verifyName(Student student){
        return Observable.create(emitter -> {
            System.out.println("Verificando el nombre del estudiante: " + student.getName());
            Thread.sleep(1000);

            if (student.getName().trim().length() < 3){
                emitter.onError(new IllegalArgumentException("Error en la longitud del nombre del estudiante..."));
            }else{
                emitter.onNext(student);
            }
            emitter.onComplete();
        });
    }

}
