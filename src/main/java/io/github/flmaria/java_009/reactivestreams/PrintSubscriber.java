package io.github.flmaria.java_009.reactivestreams;

import java.util.concurrent.Flow;

// A simple Subscriber that prints the received items
class PrintSubscriber implements Flow.Subscriber<Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1); // Request the first item
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("Received: " + item);
        subscription.request(1); // Request the next item
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Processing complete");
    }
}