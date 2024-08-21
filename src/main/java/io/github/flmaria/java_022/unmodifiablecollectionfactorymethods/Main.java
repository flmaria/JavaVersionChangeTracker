package io.github.flmaria.java_022.unmodifiablecollectionfactorymethods;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<String> unmodifiableList = List.of("Java", "Python", "C++");
        // unmodifiableList.add("Ruby"); // This will throw UnsupportedOperationException

        Set<String> unmodifiableSet = Set.of("Apple", "Banana", "Orange");
        // unmodifiableSet.add("Grapes"); // This will throw UnsupportedOperationException

        Map<String, Integer> unmodifiableMap = Map.of("one", 1, "two", 2, "three", 3);
        // unmodifiableMap.put("four", 4); // This will throw UnsupportedOperationException


    }

}
