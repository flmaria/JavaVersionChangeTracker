package io.github.flmaria.java_009.optionalclassimprovements;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        //ifPresentOrElse() - This method provides an alternative to ifPresent(Consumer<? super T> action). It allows you to specify a Runnable action that will be executed if the Optional is empty, making it easier to handle both present and absent values in a single operation

        Optional<String> optional = Optional.of("Hello, World!");

        optional.ifPresentOrElse(
                value -> System.out.println("Value is present: " + value),
                () -> System.out.println("Value is absent")
        );

        Optional<String> emptyOptional = Optional.empty();

        emptyOptional.ifPresentOrElse(
                value -> System.out.println("Value is present: " + value),
                () -> System.out.println("Value is absent")
        );

        //stream() - Converts an Optional<T> to a Stream<T>. If a value is present, the stream contains a single element; if the Optional is empty, the stream is empty. This is particularly useful when you want to work with optional values in a stream pipeline.

        Optional<String> optional2 = Optional.of("Hello, World!");

        optional2.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Optional<String> emptyOptional2 = Optional.empty();

        long count = emptyOptional2.stream().count();
        System.out.println("Stream count: " + count);

        //or() - Returns the current Optional if a value is present; otherwise, it returns the Optional produced by the supplied Supplier. This allows for more flexible fallback logic when dealing with optional values.

        Optional<String> optional3 = Optional.of("Hello, World!");
        Optional<String> fallback = Optional.of("Fallback Value");

        String result = optional3.or(() -> fallback).get();
        System.out.println("Result: " + result);

        Optional<String> emptyOptional3 = Optional.empty();

        String fallbackResult = emptyOptional3.or(() -> fallback).get();
        System.out.println("Result: " + fallbackResult);

        //orElseThrow() - Method was enhanced to allow it to be called without any arguments. In this case, it behaves like get() but throws a NoSuchElementException if no value is present. This simplifies the code when you want to throw an exception for absent values but don't need to specify a custom exception

        Optional<String> optional4 = Optional.of("Hello, World!");

        String value = optional4.orElseThrow();
        System.out.println("Value: " + value);

        Optional<String> emptyOptional4 = Optional.empty();

        try {
            emptyOptional4.orElseThrow(); // This will throw NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("Exception: " + e.getMessage());
        }


    }

}
