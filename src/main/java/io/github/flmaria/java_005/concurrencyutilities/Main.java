package io.github.flmaria.java_005.concurrencyutilities;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {

                }
            });
        }

        executor.shutdown();

        //----- Callable and Future:

        Callable<Integer> callableTask = () -> {
            return 123;
        };

        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor2.submit(callableTask);

        // Perform other tasks...
        Integer result = future.get(); // Blocks until the task is completed

        //---- BlockingQueue

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        // Producer
        new Thread(() -> {
            try {
                queue.put(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer
        new Thread(() -> {
            try {
                Integer value = queue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        //--- Locks and Condition Variables

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();
        try {
            condition.await(); // Releases the lock and waits
            // Do some work
            condition.signal(); // Wakes up a waiting thread
        } finally {
            lock.unlock();
        }

        //---- Atomic Variables:

        AtomicInteger counter = new AtomicInteger(0);

        int newValue = counter.incrementAndGet(); // Atomically increments the value by 1

        //----- Concurrent Collections:

        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key", 42);

        Integer value = map.get("key");

        //--- CountDownLatch - A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.

        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                // Perform task
                latch.countDown(); // Decrease count
            }).start();
        }

        latch.await(); // Wait until the count reaches zero

        //--- CyclicBarrier - A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.

        CyclicBarrier barrier = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                // Perform task
                try {
                    barrier.await(); // Wait for others
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                // Continue execution after all have reached the barrier
            }).start();
        }

        //--- Semaphore - A counting semaphore that allows a thread to access a resource only if a permit is available. Useful for limiting the number of threads that can access a resource.

        Semaphore semaphore = new Semaphore(2);

        semaphore.acquire();
        try {
            // Access the resource
        } finally {
            semaphore.release();
        }









    }

}
