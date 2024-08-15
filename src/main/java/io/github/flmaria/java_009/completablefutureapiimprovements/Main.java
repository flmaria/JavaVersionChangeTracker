package io.github.flmaria.java_009.completablefutureapiimprovements;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();

        // CompletableFuture with a timeout
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate long-running task
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Completed!";
        }, executor).orTimeout(3, TimeUnit.SECONDS).exceptionally(ex -> "Timed out!");

        future.thenAccept(System.out::println);

        // CompletableFuture that completes on timeout with a default value
        CompletableFuture<String> futureWithTimeoutValue = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate long-running task
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Completed!";
        }, executor).completeOnTimeout("Default Value", 3, TimeUnit.SECONDS);

        futureWithTimeoutValue.thenAccept(System.out::println);

        // CompletableFuture with delayed execution
        Executor delayedExecutor = CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS, executor);
        CompletableFuture.runAsync(() -> System.out.println("Task executed after delay"), delayedExecutor);

        // ExceptionallyCompose Example
        CompletableFuture<Object> exceptionalFuture = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Error occurred");
        }, executor).exceptionallyCompose(ex -> CompletableFuture.supplyAsync(() -> "Recovered from " + ex.getMessage()));
        exceptionalFuture.thenAccept(System.out::println);

        // Prevent the program from terminating immediately
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

