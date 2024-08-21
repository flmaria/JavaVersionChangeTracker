package io.github.flmaria.java_008.collectorsclass;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //toList(): Collects elements into a List.
        List<String> names = Stream.of("John", "Paul", "George", "Ringo")
                .collect(Collectors.toList());

        //toSet(): Collects elements into a Set.
        Set<String> names2 = Stream.of("John", "Paul", "George", "Ringo")
                .collect(Collectors.toSet());

        //toMap(): Collects elements into a Map. You need to provide two functions: one for the key and one for the value.
        Map<String, Integer> nameLengthMap = Stream.of("John", "Paul", "George", "Ringo")
                .collect(Collectors.toMap(name -> name, name -> name.length()));

        //If there are duplicate keys, you can provide a merge function to handle them:
        Map<String, Integer> nameLengthMap2 = Stream.of("John", "Paul", "George", "Paul")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length(),
                        (existing, replacement) -> existing));  // Keep the existing value

        //joining(): Concatenates the elements of a stream into a single String. You can also specify a delimiter, a prefix, and a suffix.
        String result = Stream.of("John", "Paul", "George", "Ringo")
                .collect(Collectors.joining());

        //groupingBy(): Groups elements of the stream by a classifier function and returns a Map where the keys are the result of applying the classifier function and the values are Lists of items.
        Map<Integer, List<String>> groupedByLength = Stream.of("John", "Paul", "George", "Ringo")
                .collect(Collectors.groupingBy(String::length));

        //partitioningBy(): Similar to groupingBy, but the classifier function is a Predicate, so it partitions the elements into two groups: true and false.
        Map<Boolean, List<String>> partitioned = Stream.of("John", "Paul", "George", "Ringo")
                .collect(Collectors.partitioningBy(name -> name.length() > 4));

        //counting()
        long count = Stream.of("John", "Paul", "George", "Ringo")
                .collect(Collectors.counting());

        //reducing(): Performs a reduction on the elements of the stream using an associative accumulation function and returns an Optional.
        Optional<String> concatenated = Stream.of("John", "Paul", "George", "Ringo")
                .collect(Collectors.reducing((s1, s2) -> s1 + ", " + s2));
        concatenated.ifPresent(System.out::println);  // Outputs: "John, Paul, George, Ringo"

        //Custom Collector
        Stream<String> stream = Stream.of("John", "Paul", "George", "Ringo");

        Collector<String, StringBuilder, String> customCollector = Collector.of(
                StringBuilder::new,           // Supplier
                (sb, s) -> sb.append(s).append("|"),  // Accumulator
                StringBuilder::append,        // Combiner
                sb -> sb.toString());         // Finisher

        String result2 = stream.collect(customCollector);
        System.out.println(result2);  // Outputs: "John|Paul|George|Ringo|"





    }

}
