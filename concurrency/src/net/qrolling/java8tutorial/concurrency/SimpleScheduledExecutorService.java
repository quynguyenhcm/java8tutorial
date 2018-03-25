package net.qrolling.java8tutorial.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SimpleScheduledExecutorService {
    public static void main(String arg[]) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> future = executor.schedule(() -> {
            System.out.println("Scheduling: " + System.nanoTime());
        }, 4, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1000);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);

        System.out.println("Remaining Delay: " + remainingDelay);
    }
}
