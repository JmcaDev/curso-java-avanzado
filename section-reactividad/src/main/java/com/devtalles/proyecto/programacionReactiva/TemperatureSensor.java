package com.devtalles.proyecto.programacionReactiva;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class TemperatureSensor {
    static void main() throws InterruptedException {
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable<Double> temperatureStream = interval.map(
                _ -> {
                    double temp = 20 + Math.random() * 15;
                    System.out.println("Temperatura Actual: " + temp);
                    return temp;
                }
        );

        temperatureStream
                .filter(temp -> temp > 30)
                .subscribe(
                item -> System.out.println("Alerta temperatura alta: " + item),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Finalizado...")
        );


        Thread.sleep(10000);
    }
}
