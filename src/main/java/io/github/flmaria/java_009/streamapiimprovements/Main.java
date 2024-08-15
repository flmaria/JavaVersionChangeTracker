package io.github.flmaria.java_009.streamapiimprovements;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //takeWhile - The takeWhile method allows you to take elements from the stream as long as they match a given predicate. Once the predicate returns false for an element, the stream stops processing further elements.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = numbers.stream()
                .takeWhile(n -> n < 6)
                .collect(Collectors.toList());

        System.out.println(result);

        //dropWhile - method is the counterpart to takeWhile. It drops elements from the stream as long as they match the given predicate and starts taking elements once the predicate returns false.

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result2 = numbers2.stream()
                .dropWhile(n -> n < 6)
                .collect(Collectors.toList());

        System.out.println(result2);

        //ofNullable - method creates a stream with a single element if the provided element is non-null, or an empty stream if the element is null.

        Stream<String> nonNullStream = Stream.ofNullable("Hello");
        System.out.println(nonNullStream.count());

        Stream<String> nullStream = Stream.ofNullable(null);
        System.out.println(nullStream.count());

        //Stream.iterate -  method was introduced to generate infinite streams. Java 9 enhanced this method by adding an overload that allows you to specify a termination condition.

        Stream<Integer> stream = Stream.iterate(1, n -> n < 10, n -> n + 2);
        stream.forEach(System.out::println);

        //Optional.stream() - returns a stream containing the value if it is present, or an empty stream if not. This allows you to seamlessly integrate Optional values into stream pipelines.

        Optional<String> optional = Optional.of("Hello, World!");

        List<String> result3 = optional.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result3);

        //Collectors - new utility methods to the Collectors class, including Collectors.filtering(), Collectors.flatMapping(), and Collectors.mapping() which allow more complex operations during the collection process.

        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result4 = numbers3.stream()
                .collect(Collectors.filtering(n -> n % 2 == 0, Collectors.toList()));

        System.out.println(result4);

        //Collectors.filtering() - Allows you to apply a filter before collecting the elements.

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> result5 = listOfLists.stream()
                .collect(Collectors.flatMapping(List::stream, Collectors.toList()));

        System.out.println(result5);

        //Collectors.mapping() -  Allows you to apply a mapping function before collecting the elements.

        List<String> strings = Arrays.asList("a", "bb", "ccc");

        List<Integer> lengths = strings.stream()
                .collect(Collectors.mapping(String::length, Collectors.toList()));

        System.out.println(lengths);

    }

}
