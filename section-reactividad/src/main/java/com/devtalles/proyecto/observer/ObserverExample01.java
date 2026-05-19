package com.devtalles.proyecto.observer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ObserverExample01 {
    static void main() {
        Observable<String> courseStream = Observable
                .fromIterable(
                        Arrays.asList("HTML", "CSS", null, "C", "Java").stream().filter(Objects::nonNull).toList()
                );

        Observer<String> observer = new Observer<>() {
            private Disposable disposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.disposable = d;
                System.out.println("Estoy suscripto");
            }

            @Override
            public void onNext(String s) {
                if(s.equalsIgnoreCase("c")){
                    disposable.dispose();
                }else{
                    System.out.println("Recibí: " + s);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("Finalizado...");
            }
        };

        Observer<String> observer2 = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Estoy suscripto al curso soy observer2!");
            }

            @Override
            public void onNext(String s) {
                System.out.println("Soy observer2 y Recibí: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("Finalizado... observer2");
            }
        };

        courseStream.subscribe(observer);
        courseStream.subscribe(observer2);
    }
}
