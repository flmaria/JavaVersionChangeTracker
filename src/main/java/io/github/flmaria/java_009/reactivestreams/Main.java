package io.github.flmaria.java_009.reactivestreams;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Create a Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // Create a Subscriber
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("Subscribed");
                // Request the first item
                subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                System.out.println("Received: " + item);
                // Process the item (simulated delay)
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Request the next item
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error occurred: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("All items processed");
            }
        };

        // Subscribe the Subscriber to the Publisher
        publisher.subscribe(subscriber);

        // Publish some items
        System.out.println("Publishing items...");
        publisher.submit("Item 1");
        publisher.submit("Item 2");
        publisher.submit("Item 3");

        // Close the publisher
        publisher.close();

        // Allow time for all items to be processed
        Thread.sleep(5000);
    }
}

