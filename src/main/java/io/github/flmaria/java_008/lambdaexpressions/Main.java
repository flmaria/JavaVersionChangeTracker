package io.github.flmaria.java_008.lambdaexpressions;

import java.util.function.Function;

import java.util.function.Predicate;
import java.util.Arrays;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.function.Supplier;




public class Main {

    public static void main(String[] args) {

        //Composing Functions with andThen and compose
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> addTen = x -> x + 10;

        // andThen: (x * 2) + 10
        Function<Integer, Integer> addThenMultiply = multiplyByTwo.andThen(addTen);

        // compose: (x + 10) * 2
        Function<Integer, Integer> multiplyThenAdd = multiplyByTwo.compose(addTen);

        System.out.println("andThen result: " + addThenMultiply.apply(5)); // Outputs: 20
        System.out.println("compose result: " + multiplyThenAdd.apply(5)); // Outputs: 30

        //Using Predicate with Complex Conditions -------------------------------------------
        List<String> names = Arrays.asList("Tom", "Jerry", "Spike", "Tyke");

        Predicate<String> startsWithT = name -> name.startsWith("T");
        Predicate<String> lengthIs4 = name -> name.length() == 4;

        // Combined Predicate: names that start with 'T' and have a length of 4
        Predicate<String> combinedPredicate = startsWithT.and(lengthIs4);

        names.stream()
                .filter(combinedPredicate)
                .forEach(System.out::println); // Outputs: "Tom", "Tyke"

        //Using Optional with Lambda Expressions -------------------------------------------
        Optional<String> optional = Optional.of("Hello");

        optional.map(String::toUpperCase)
                .ifPresent(System.out::println); // Outputs: HELLO

        Optional<String> emptyOptional = Optional.empty();

        String result = emptyOptional.orElseGet(() -> "Default Value");
        System.out.println(result); // Outputs: Default Value

        //Creating a Custom Collector -------------------------------------------
        Collector<Integer, StringBuilder, String> customCollector = Collector.of(
                StringBuilder::new,                           // Supplier
                (sb, i) -> sb.append(i).append(", "),         // Accumulator
                StringBuilder::append,                        // Combiner
                sb -> sb.substring(0, sb.length() - 2));      // Finisher

        String result2 = IntStream.range(1, 6)
                .boxed()
                .collect(customCollector);

        System.out.println(result2); // Outputs: "1, 2, 3, 4, 5"

        //Using Lambdas with Higher-Order Functions -------------------------------------------
        Function<Integer, Function<Integer, Integer>> multiplyBy = x -> (y -> x * y);

        Function<Integer, Integer> multiplyBy5 = multiplyBy.apply(5);

        System.out.println(multiplyBy5.apply(10)); // Outputs: 50

        //Using Supplier and Lazy Evaluation -------------------------------------------
        Supplier<String> lazyValue = () -> {
            System.out.println("Computing the value...");
            return "Lazy Value";
        };

        // Lazy evaluation: the supplier is only invoked when needed
        System.out.println("Before getting the value");
        String value = lazyValue.get();  // "Computing the value..." is printed here
        System.out.println("Value: " + value); // Outputs: Value: Lazy Value

    }

}
