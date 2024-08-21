package io.github.flmaria.java_008.methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        // Lambda expression
        Function<String, Integer> lambda = s -> Integer.parseInt(s);

        // Method reference to a static method
        Function<String, Integer> methodRef = Integer::parseInt;

        System.out.println(methodRef.apply("123"));  // Outputs: 123

        //----

        String str = "Hello, World!";

        // Lambda expression
        Supplier<String> lambda2 = () -> str.toUpperCase();

        // Method reference to an instance method of a particular object
        Supplier<String> methodRef2 = str::toUpperCase;

        System.out.println(methodRef2.get());  // Outputs: HELLO, WORLD!

        //----

        List<String> names = Arrays.asList("John", "Paul", "George", "Ringo");

        // Lambda expression
        names.forEach(name -> System.out.println(name));

        // Method reference to an instance method of an arbitrary object of a particular type
        names.forEach(System.out::println);

        //---

        // Lambda expression
        Supplier<MyClass> lambda3 = () -> new MyClass();

        // Method reference to a constructor
        Supplier<MyClass> methodRef3 = MyClass::new;

        MyClass myClassInstance = methodRef3.get();


        //-----

        List<String> names2 = Arrays.asList("John", "Paul", "George", "Ringo");
        names2.sort((a, b) -> a.compareToIgnoreCase(b));

        names2.sort(String::compareToIgnoreCase);




    }

}
