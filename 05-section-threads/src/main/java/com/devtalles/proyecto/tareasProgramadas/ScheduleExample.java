package com.devtalles.proyecto.tareasProgramadas;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExample {
    static void main() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

//        executorService.schedule( () -> {
//            System.out.println("Tarea despues de 4 segundos");
//        }, 4, TimeUnit.SECONDS);
//
//        executorService.schedule( () -> {
//            System.out.println("Tarea despues de 5 segundos");
//        }, 5, TimeUnit.SECONDS);
//
//        executorService.shutdown();

//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("Tarea de 2 segundos");
//                timer.cancel();
//            }
//        }, 2000);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            int counter = 0;
            @Override
            public void run() {
                System.out.println("Enviando recordatorio...");
                counter++;
                if(counter > 3){
                    System.out.println("Se enviaron todos los recordatorios...");
                    executor.shutdown();
                }
            }
        };

        executor.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);



    }
}
