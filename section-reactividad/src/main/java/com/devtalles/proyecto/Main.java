package com.devtalles.proyecto;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    static void main() {
        List<Integer> numbres = List.of(1,2,3,4,5);

        long start = System.currentTimeMillis();

        numbres.parallelStream().map(
                n -> {
                    try{
//                        Thread.sleep(1000);
                        TimeUnit.SECONDS.sleep(1);
                    }catch(InterruptedException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("Procesando numero: " + n + " en hilo: " + Thread.currentThread().getName());
                    return n*2;
                }).forEach(System.out::println);

        long end = System.currentTimeMillis();

        System.out.println("Tiempo total (secuencial): " + (end - start) + " ms");
    }
}
