package io.github.flmaria.java_005.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Using the generic class
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        Integer value = integerBox.get();

        //---
        List<String> list = new ArrayList<>();
        list.add("Hello");
        // list.add(10); // Compile-time error, as 10 is not a String

        //----
        // Before Generics
        List list2 = new ArrayList();
        list2.add("Hello");
        String str = (String) list2.get(0); // Need to cast

        // With Generics
        List<String> list3 = new ArrayList<>();
        list3.add("Hello");
        String str2 = list3.get(0); // No casting needed

        //---
        // Only Number or subclasses of Number can be passed

        Main m = new Main();
        m.print(10);      // OK, 10 is an Integer which is a subclass of Number
        m.print(10.5);    // OK, 10.5 is a Double which is a subclass of Number
        // print("Hello"); // Compile-time error


        //---

        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> strList = Arrays.asList("one", "two", "three");

        m.printList(intList); // Works
        m.printList(strList); // Works

    }

    public <T extends Number> void print(T value) {
        System.out.println(value);
    }

    public void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

}
