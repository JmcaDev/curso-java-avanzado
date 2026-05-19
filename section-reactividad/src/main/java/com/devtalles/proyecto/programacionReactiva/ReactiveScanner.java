package com.devtalles.proyecto.programacionReactiva;

import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.Scanner;

public class ReactiveScanner {
    static void main() {
        PublishSubject<String> inputStream = PublishSubject.create();

        inputStream.subscribe(
                item -> System.out.println("Recibido: " + item.toUpperCase()),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Finalizado...")
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un texto o 'salir' para terminal la app: ");

        while (true) {
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("salir")) {
                inputStream.onComplete();
                break;
            }

            inputStream.onNext(input);
        }

        scanner.close();
    }
}
