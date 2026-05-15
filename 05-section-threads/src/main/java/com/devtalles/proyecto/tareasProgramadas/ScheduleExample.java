package com.devtalles.proyecto.tareasProgramadas;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExample {
    static void main() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.schedule( () -> {
            System.out.println("Tarea despues de 4 segundos");
        }, 4, TimeUnit.SECONDS);

        executorService.shutdown();
    }
}
