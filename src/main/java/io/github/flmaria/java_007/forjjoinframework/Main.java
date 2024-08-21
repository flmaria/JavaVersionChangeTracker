package io.github.flmaria.java_007.forjjoinframework;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class Main extends RecursiveTask<Integer> {

    private final int[] array;
    private final int start, end;
    private static final int THRESHOLD = 10;

    public Main(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            Main leftTask = new Main(array, start, mid);
            Main rightTask = new Main(array, mid, end);

            leftTask.fork(); // Fork the left task
            int rightResult = rightTask.compute(); // Compute the right task
            int leftResult = leftTask.join(); // Join the left task

            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        ForkJoinPool pool = new ForkJoinPool();
        Main task = new Main(array, 0, array.length);

        int result = pool.invoke(task);
        System.out.println("Sum: " + result);
    }

}
