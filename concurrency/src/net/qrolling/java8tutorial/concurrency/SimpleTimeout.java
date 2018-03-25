package net.qrolling.java8tutorial.concurrency;

import java.util.concurrent.*;

public class SimpleTimeout {
    public static void main(String arg[]) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String> future = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "I am a callable";
        });

        String result = future.get(1, TimeUnit.SECONDS);
        System.out.println("result: " + result); // Calling get should block the current thread and wait till the callable is finished
    }
}
