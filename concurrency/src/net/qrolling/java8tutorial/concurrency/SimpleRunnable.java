package net.qrolling.java8tutorial.concurrency;

public class SimpleRunnable {
    public static void main(String arg[]) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Finished!");

    }
}
