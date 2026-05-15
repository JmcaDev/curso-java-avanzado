package com.devtalles.proyecto.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutdownComparison {
    static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Tarea Iniciando con Executor: " + taskId + " " + Thread.currentThread().getName());
                try {
                    //Simulacion de tiempo de espera API
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println("Tarea " + taskId + " fue interrumpida");
                    try{
                        Thread.sleep(1001);
                    }catch (InterruptedException error){
                        return;
                    }
                    return;
                }
                System.out.println("Tarea " + taskId + " Finalizada");
            });
        }

        Thread.sleep(5000);

        boolean error = true;

        if(error){
            System.out.println("Situacion critica");
            executor.shutdownNow();
        }else{
            System.out.println("Finalizacion ordenada");
            executor.shutdown();
        }

        if(executor.awaitTermination(1, TimeUnit.SECONDS)){
            System.out.println("Tareas finalizadas correctamente");
        }else{
            System.out.println("Tareas NO finalizadas correctamente");
        }
    }
}
