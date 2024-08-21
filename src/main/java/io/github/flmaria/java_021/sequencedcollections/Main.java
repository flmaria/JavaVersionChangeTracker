package io.github.flmaria.java_021.sequencedcollections;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //1. SequencedCollection Example

        // Using LinkedList as a SequencedCollection
        SequencedCollection<String> sequencedCollection = new LinkedList<>();

        // Adding elements
        sequencedCollection.add("First");
        sequencedCollection.add("Second");
        sequencedCollection.add("Third");

        // Accessing the first and last elements
        System.out.println("First Element: " + sequencedCollection.getFirst()); // Outputs: First
        System.out.println("Last Element: " + sequencedCollection.getLast());   // Outputs: Third

        // Removing the first and last elements
        sequencedCollection.removeFirst();
        sequencedCollection.removeLast();

        // Displaying remaining elements
        System.out.println("Remaining Elements: " + sequencedCollection);

//        2. SequencedSet Example


        // Using LinkedHashSet as a SequencedSet
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();

        // Adding elements
        sequencedSet.add("Alpha");
        sequencedSet.add("Beta");
        sequencedSet.add("Gamma");

        // Accessing the first and last elements
        System.out.println("First Element: " + sequencedSet.getFirst()); // Outputs: Alpha
        System.out.println("Last Element: " + sequencedSet.getLast());   // Outputs: Gamma

        // Removing the first and last elements
        sequencedSet.removeFirst();
        sequencedSet.removeLast();

        // Displaying remaining elements
        System.out.println("Remaining Elements: " + sequencedSet);

//        3. SequencedMap Example
        // Using LinkedHashMap as a SequencedMap
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();

        // Adding entries
        sequencedMap.put(1, "One");
        sequencedMap.put(2, "Two");
        sequencedMap.put(3, "Three");

        // Accessing the first and last entries
        System.out.println("First Entry: " + sequencedMap.firstEntry()); // Outputs: 1=One
        System.out.println("Last Entry: " + sequencedMap.lastEntry());   // Outputs: 3=Three

        // Polling (removing) the first and last entries
        sequencedMap.pollFirstEntry();
        sequencedMap.pollLastEntry();

        // Displaying remaining entries
        System.out.println("Remaining Entries: " + sequencedMap);



    }

}
