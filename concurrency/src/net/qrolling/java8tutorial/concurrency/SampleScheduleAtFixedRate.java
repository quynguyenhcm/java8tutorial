package net.qrolling.java8tutorial.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SampleScheduleAtFixedRate {
    public static void main(String arg[]) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Scheduling: " + System.nanoTime());
        }, 4, 1, TimeUnit.SECONDS);
    }
}
