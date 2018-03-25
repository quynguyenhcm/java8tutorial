package net.qrolling.java8tutorial.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleExecutor {
    public static void main(String arg[]) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
        System.out.println("Finished!");

        try {
            System.out.println("Shutting down!");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("I need to shutdown immediately!!! tasks are interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("Cancel un-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("Shutdown finished");
        }
    }
}
