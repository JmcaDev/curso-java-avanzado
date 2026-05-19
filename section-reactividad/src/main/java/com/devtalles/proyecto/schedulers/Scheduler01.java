package com.devtalles.proyecto.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Scheduler01 {
    static void main() throws InterruptedException {
        Observable.just("Hola")
                .subscribeOn(Schedulers.io())
                .doOnNext(string -> System.out.println(string + " Just: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.computation())
                .map(s -> s + " mundo")
                .doOnNext(string -> System.out.println(string + " Map: " + Thread.currentThread().getName()))
                .subscribe( s -> System.out.println("Resultado: " + s + " " + Thread.currentThread().getName()));

        Thread.sleep(1000);
    }
}
