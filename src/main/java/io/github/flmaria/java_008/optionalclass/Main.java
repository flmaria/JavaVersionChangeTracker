package io.github.flmaria.java_008.optionalclass;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        //creating optioonal
        Optional<String> empty = Optional.empty();

        Optional<String> optional = Optional.of("Hello");

        Optional<String> optional2 = Optional.ofNullable(null);


        //Common Methods of the Optional Class

        Optional<String> optional3 = Optional.of("Hello");
        if (optional3.isPresent()) {
            System.out.println(optional3.get()); // Outputs: Hello
        }

        Optional<String> optional4 = Optional.of("Hello");
        optional4.ifPresent(value -> System.out.println(value)); // Outputs: Hello


        Optional<String> optional5 = Optional.ofNullable(null);
        String value = optional5.orElse("Default Value");
        System.out.println(value); // Outputs: Default Value


        Optional<String> optional6 = Optional.ofNullable(null);
        String value2 = optional6.orElseGet(() -> "Default Value from Supplier");
        System.out.println(value2); // Outputs: Default Value from Supplier


        Optional<String> optional7 = Optional.ofNullable(null);
        String value3 = optional7.orElseThrow(() -> new IllegalArgumentException("Value is absent"));


        Optional<String> optional8 = Optional.of("Hello");
        String value4 = optional8.get(); // Only use if you are sure the value is present
        System.out.println(value4); // Outputs: Hello

        Optional<String> optional9 = Optional.of("Hello");
        Optional<Integer> lengthOptional = optional9.map(String::length);
        System.out.println(lengthOptional.get()); // Outputs: 5

        Optional<String> optional10 = Optional.of("Hello");
        Optional<String> upperOptional = optional10.flatMap(s -> Optional.of(s.toUpperCase()));
        System.out.println(upperOptional.get()); // Outputs: HELLO

        Optional<String> optional11 = Optional.of("Hello");
        Optional<String> filteredOptional = optional11.filter(s -> s.startsWith("H"));
        System.out.println(filteredOptional.isPresent()); // Outputs: true












    }

}
