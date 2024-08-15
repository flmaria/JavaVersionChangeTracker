package io.github.flmaria.java_011.varkeywordinlambdaexpression;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sum the numbers using a lambda expression with 'var' in parameters
        int sum = numbers.stream()
                .reduce(0, (var a, var b) -> a + b);

        // Print the result
        System.out.println("Sum of numbers: " + sum);

        // Filter even numbers using a lambda expression with 'var' and an annotation
        List<Integer> evenNumbers = numbers.stream()
                .filter((var n) -> n % 2 == 0)
                .toList();

        // Print the even numbers
        System.out.println("Even numbers: " + evenNumbers);
    }
}

