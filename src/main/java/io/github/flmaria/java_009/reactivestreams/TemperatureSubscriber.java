package io.github.flmaria.java_009.reactivestreams;

import java.util.concurrent.*;

class TemperatureSubscriber implements Flow.Subscriber<Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("Subscribed to temperature stream");
        subscription.request(1); // Request the first item
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("Received temperature: " + item + "°C");
        if (item > 25) {
            System.out.println("Warning: High temperature!");
        }
        subscription.request(1); // Request the next item
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("Error occurred: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("All temperatures processed");
    }
}
