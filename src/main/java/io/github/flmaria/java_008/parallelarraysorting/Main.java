package io.github.flmaria.java_008.parallelarraysorting;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[10_000_000];
        Random random = new Random();

        // Fill the array with random numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1_000_000);
        }

        // Clone the array for fair comparison
        int[] numbersForSequentialSort = numbers.clone();
        int[] numbersForParallelSort = numbers.clone();

        // Measure time for sequential sort
        long startSequential = System.currentTimeMillis();
        Arrays.sort(numbersForSequentialSort);
        long endSequential = System.currentTimeMillis();
        System.out.println("Sequential sort took: " + (endSequential - startSequential) + " ms");

        // Measure time for parallel sort
        long startParallel = System.currentTimeMillis();
        Arrays.parallelSort(numbersForParallelSort);
        long endParallel = System.currentTimeMillis();
        System.out.println("Parallel sort took: " + (endParallel - startParallel) + " ms");
    }


}
