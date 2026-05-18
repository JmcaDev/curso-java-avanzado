package com.devtalles.proyecto.tareasProgramadas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskOnSpecificDay {

    static void main() {
        LocalDateTime dateTime = LocalDateTime.of(2026, 05, 18, 10,3);

        LocalDateTime now = LocalDateTime.now();

        long delay = Duration.between(now, dateTime).toMillis();

        if(delay < 0){
            System.out.println("La fecha ya paso...");
            return;
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        executor.schedule(() -> {
            System.out.println("Tarea programada");
            executor.shutdown();
        }, delay, TimeUnit.MILLISECONDS);
    }
}
