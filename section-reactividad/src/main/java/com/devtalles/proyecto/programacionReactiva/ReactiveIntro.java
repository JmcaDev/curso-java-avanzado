package com.devtalles.proyecto.programacionReactiva;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

import java.util.Scanner;

public class ReactiveIntro {
    static void main() {

        //Primer ejemplo
        Observable<String> courseStream = Observable.just("HTML", "CSS", "JAVA", "C");

        courseStream.subscribe(
                item -> System.out.println("Recibido: " + item),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Finalizado...")
        );

        ObservableOnSubscribe subscribe = emitter -> {
            Scanner scanner = new Scanner(System.in);
            String input;
            while(true){
                System.out.println("Ingrese un nombre o ingrese 'salir' para terminar el programa : ");
                input = scanner.nextLine();
                if(input.equalsIgnoreCase("salir")){
                    break;
                }
                emitter.onNext(input);
            }
        };

        Observable<String> names = Observable.create(subscribe);

        names.subscribe(
                item -> System.out.println("Nombre ingresado es: " + item),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Finalizado...")
        );
    }
}
