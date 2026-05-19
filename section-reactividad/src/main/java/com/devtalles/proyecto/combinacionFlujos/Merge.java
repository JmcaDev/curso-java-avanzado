package com.devtalles.proyecto.combinacionFlujos;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Merge {
    static void main() throws InterruptedException {
//        Observable<String> students = Observable.just("Jose", "Mario", "Ana", "Juana", "Fernando")
//                .delay(1, TimeUnit.SECONDS);
//        Observable<String> teacher = Observable.just("Prof. Carlos", "Prof. Ana", "Prof. Juan", "Prof. Ricardo");
//
//        Observable.merge(students, teacher).subscribe(System.out::println);
//
//        Thread.sleep(2000);

//        Observable<String> students = Observable.just("Jose", "Mario", "Ana", "Juana", "Fernando")
//                .delay(1, TimeUnit.SECONDS);
//        Observable<String> teacher = Observable.just("Prof. Carlos", "Prof. Ana", "Prof. Juan", "Prof. Ricardo");
//
//        Observable.concat(teacher, students).subscribe(System.out::println);
//
//        Thread.sleep(1000);

        Observable<String> students = Observable.just("Jose", "Mario", "Ana", "Juana", "Fernando");
        Observable<Integer> ages = Observable.just( 20, 30, 40, 50);

        Observable.zip(students, ages, (x, y) -> "Nombre: " + x + ", Edad: "+ y).subscribe(item -> System.out.println(item));

    }
}
