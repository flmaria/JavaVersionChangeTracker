package io.github.flmaria.java_008.completablefutureandtheconcurrencyapienhancements;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //supplyAsync (returns a result):
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running computation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result from the async task";
        });

        // Blocking call to get the result (not recommended in real async scenarios)
        System.out.println(future.get());


        //runAsync (does not return a result):
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            // Simulate a long-running computation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed!");
        });

        // Block until the task is done (for demonstration)
        future2.join();

        //thenApply (transform the result):
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 50)
                .thenApply(result -> result * 2);  // Transform the result by doubling it

        System.out.println(future3.join());  // Outputs: 100

        //thenAccept (consume the result without transforming):
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(result -> System.out.println("Result: " + result));  // Outputs: Result: Hello


        //thenCompose (flatMap-style chaining):
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> 2)
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result * 3));  // Chain another future

        System.out.println(future4.join());  // Outputs: 6

        //thenCombine (combine two futures):
        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> 5);
        CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Integer> combinedFuture = future5.thenCombine(future6, (result1, result2) -> result1 + result2);

        System.out.println(combinedFuture.join());  // Outputs: 15

        //allOf (wait for all futures to complete):
        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> "Task 1");
        CompletableFuture<String> future8 = CompletableFuture.supplyAsync(() -> "Task 2");

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future7, future8);

        // Block and wait for all futures to complete
        allFutures.join();

        System.out.println(future7.join());  // Outputs: Task 1
        System.out.println(future8.join());  // Outputs: Task 2

        //anyOf (return when any future completes):
        CompletableFuture<String> future9 = CompletableFuture.supplyAsync(() -> "Task 1");
        CompletableFuture<String> future10 = CompletableFuture.supplyAsync(() -> "Task 2");

        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(future9, future10);

        System.out.println(anyFuture.join());  // Outputs: Task 1 or Task 2 (whichever completes first)

        //exceptionally (handle an exception and return a fallback value):
        CompletableFuture<Integer> future11 = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong!");
            return 10;
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return 0;
        });

        System.out.println(future11.join());  // Outputs: 0

        //handle (handle both result and exception):
        CompletableFuture<Integer> future12 = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong!");
            return 10;
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Error: " + ex.getMessage());
                return 0;
            }
            return result;
        });

        System.out.println(future12.join());  // Outputs: 0

        //whenComplete (handle side effects after completion, without altering the result):
        CompletableFuture<Integer> future13 = CompletableFuture.supplyAsync(() -> 10);

        future13.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Error: " + ex.getMessage());
            } else {
                System.out.println("Result: " + result);  // Outputs: Result: 10
            }
        }).join();

        //Completing a CompletableFuture Manually
        CompletableFuture<String> future14 = new CompletableFuture<>();

        // Complete the future manually from another thread
        new Thread(() -> {
            try {
                Thread.sleep(1000);  // Simulate delay
                future14.complete("Manual completion");
            } catch (InterruptedException e) {
                future14.completeExceptionally(e);
            }
        }).start();

        System.out.println(future14.join());  // Outputs: Manual completion







    }

}
