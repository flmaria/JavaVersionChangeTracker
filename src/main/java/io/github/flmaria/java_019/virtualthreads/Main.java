package io.github.flmaria.java_019.virtualthreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ExecutorService;

public class Main {

    // Simulated method to fetch data from an external service
    private static String fetchDataFromService(int requestId) {
        try {
            // Simulating a delay, like an I/O operation (e.g., network call)
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Error fetching data for request " + requestId;
        }
        return "Data for request " + requestId;
    }

    // Simulated method to process a client request
    private static void handleRequest(int requestId) {
        System.out.println("Handling request " + requestId + " on " + Thread.currentThread());

        // Simulate fetching data from an external service
        String data = fetchDataFromService(requestId);

        // Simulate processing the fetched data
        System.out.println("Processed " + data + " for request " + requestId);
    }

    public static void main(String[] args) {

//        @TODO: update jdk

        // Creating an ExecutorService backed by virtual threads
        ExecutorService executorService = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory());

        // Simulate handling multiple client requests
        for (int i = 1; i <= 10; i++) {
            int requestId = i;

            // Submit each request as a separate virtual thread task
            executorService.submit(() -> handleRequest(requestId));
        }

//         Shut down the executor service gracefully
        executorService.shutdown();
    }

}
