package io.github.flmaria.java_009.reactivestreams;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Example02AsynchronousTemperatureStream {

    public static void main(String[] args) {
        // Create a SubmissionPublisher which is a concrete implementation of Publisher
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        // Create a Subscriber
        TemperatureSubscriber subscriber = new TemperatureSubscriber();

        // Subscribe the subscriber to the publisher
        publisher.subscribe(subscriber);

        // Simulate temperature readings being published asynchronously
        CompletableFuture.runAsync(() -> {
            AtomicInteger count = new AtomicInteger(1);
            while (count.get() <= 10) {
                int temp = 20 + (int)(Math.random() * 10);
                System.out.println("Publishing temperature: " + temp + "°C");
                publisher.submit(temp);
                count.incrementAndGet();
                try {
                    Thread.sleep(1000); // Delay to simulate asynchronous data emission
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            publisher.close(); // Close the publisher when done
        });

        // Keep the application running to allow the stream to be processed
        try {
            Thread.sleep(12000); // Sleep long enough to receive all items
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
