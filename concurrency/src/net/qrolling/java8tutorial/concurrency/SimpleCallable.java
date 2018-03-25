package net.qrolling.java8tutorial.concurrency;

import java.util.concurrent.*;

public class SimpleCallable {
    public static void main(String arg[]) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return "I am a callable";
            } catch (InterruptedException e) {
                throw new IllegalStateException("Task interrupted", e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String> future = executor.submit(task);

        System.out.println("future done? " + future.isDone()); //Not yet finished
        System.out.println("result: " + future.get()); // Calling get should block the current thread and wait till the callable is finished
        System.out.println("future done? " + future.isDone());
    }
}
