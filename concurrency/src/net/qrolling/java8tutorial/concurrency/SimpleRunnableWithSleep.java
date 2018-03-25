package net.qrolling.java8tutorial.concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleRunnableWithSleep {
    public static void main(String arg[]) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Sleep " + threadName);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Awh!!! 1ms passed - " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Finished!");
    }
}
