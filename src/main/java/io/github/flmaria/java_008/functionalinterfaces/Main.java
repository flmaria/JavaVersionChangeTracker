package io.github.flmaria.java_008.functionalinterfaces;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        Function<String, Integer> lengthFunction = s -> s.length();
        System.out.println(lengthFunction.apply("Hello")); // Outputs: 5

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4)); // Outputs: true

        Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("Hello, World!"); // Outputs: Hello, World!

        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get()); // Outputs: a random double value

        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(2, 3)); // Outputs: 5

        UnaryOperator<String> toUpperCase = s -> s.toUpperCase();
        System.out.println(toUpperCase.apply("hello")); // Outputs: HELLO

        BiFunction<String, String, Integer> stringLengthSum = (s1, s2) -> s1.length() + s2.length();
        System.out.println(stringLengthSum.apply("Hello", "World")); // Outputs: 10


    }

}
