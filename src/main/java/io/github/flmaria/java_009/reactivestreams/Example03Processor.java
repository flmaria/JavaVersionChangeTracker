package io.github.flmaria.java_009.reactivestreams;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example03Processor {

    public static void main(String[] args) throws InterruptedException {
        // Create an ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Create a SubmissionPublisher (acts as the upstream Publisher)
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>(executor, Flow.defaultBufferSize());

        // Create a simple Processor that doubles the incoming integers
        Flow.Processor<Integer, Integer> processor = new DoublerProcessor();

        // Create a Subscriber
        Flow.Subscriber<Integer> subscriber = new PrintSubscriber();

        // Connect the Publisher to the Processor
        publisher.subscribe(processor);

        // Connect the Processor to the Subscriber
        processor.subscribe(subscriber);

        // Publish some items
        System.out.println("Publishing items...");
        for (int i = 1; i <= 5; i++) {
            publisher.submit(i);
        }

        // Give time for processing
        Thread.sleep(2000);

        // Close the publisher
        publisher.close();

        // Shutdown the executor
        executor.shutdown();
    }
}