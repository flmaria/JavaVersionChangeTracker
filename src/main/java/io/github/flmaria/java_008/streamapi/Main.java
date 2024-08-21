package io.github.flmaria.java_008.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        //From Collections:
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();

        //From Arrays
        String[] array = {"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(array);

//        From Values
        Stream<String> stream3 = Stream.of("a", "b", "c");

        //From a File
        Stream<String> lines = Files.lines(Paths.get("file.txt"));

        // Filtering Elements
        List<String> names = Arrays.asList("Tom", "Jerry", "Spike", "Tyke");
        Stream<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("T"));
        filteredNames.forEach(System.out::println); // Outputs: Tom, Tyke

        //Mapping Elements
        List<String> names2 = Arrays.asList("Tom", "Jerry", "Spike", "Tyke");
        Stream<String> uppercasedNames = names2.stream()
                .map(String::toUpperCase);
        uppercasedNames.forEach(System.out::println); // Outputs: TOM, JERRY, SPIKE, TYKE

        //Flat Mapping
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Tom", "Jerry"),
                Arrays.asList("Spike", "Tyke")
        );
        Stream<String> flatStream = nestedList.stream()
                .flatMap(List::stream);
        flatStream.forEach(System.out::println); // Outputs: Tom, Jerry, Spike, Tyke

        //Collecting Results
        List<String> names3 = Arrays.asList("Tom", "Jerry", "Spike", "Tyke");
        List<String> filteredNames2 = names3.stream()
                .filter(name -> name.startsWith("T"))
                .collect(Collectors.toList());
        System.out.println(filteredNames2); // Outputs: [Tom, Tyke]

        //Reducing
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum); // Outputs: 15

        //Sorting
        List<String> names4 = Arrays.asList("Tom", "Jerry", "Spike", "Tyke");
        List<String> sortedNames = names4.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNames); // Outputs: [Jerry, Spike, Tom, Tyke]

        //Distinct elements
        List<Integer> numbers5 = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        List<Integer> distinctNumbers = numbers5.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers); // Outputs: [1, 2, 3, 4]

        //Counting elements
        List<String> names5 = Arrays.asList("Tom", "Jerry", "Spike", "Tyke");
        long count = names5.stream()
                .filter(name -> name.startsWith("T"))
                .count();
        System.out.println(count); // Outputs: 2

        //Matching and finding
        boolean hasTName = names5.stream()
                .anyMatch(name -> name.startsWith("T"));

        boolean allTNames = names5.stream()
                .allMatch(name -> name.startsWith("T"));

        Optional<String> firstTName = names5.stream()
                .filter(name -> name.startsWith("T"))
                .findFirst();

        //Parallel Streams
        List<String> names6 = Arrays.asList("Tom", "Jerry", "Spike", "Tyke");
        List<String> filteredNames3 = names6.parallelStream()
                .filter(name -> name.startsWith("T"))
                .collect(Collectors.toList());
        System.out.println(filteredNames3); // Outputs: [Tom, Tyke]

    }

}
