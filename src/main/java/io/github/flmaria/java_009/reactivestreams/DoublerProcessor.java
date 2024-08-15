package io.github.flmaria.java_009.reactivestreams;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

// A simple Processor that doubles the value of incoming items
class DoublerProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<Integer, Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1); // Request the first item
    }

    @Override
    public void onNext(Integer item) {
        // Process the item and pass the result to the subscribers
        submit(item * 2);
        subscription.request(1); // Request the next item
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        closeExceptionally(throwable); // Close the processor on error
    }

    @Override
    public void onComplete() {
        close(); // Complete the processing
    }
}
