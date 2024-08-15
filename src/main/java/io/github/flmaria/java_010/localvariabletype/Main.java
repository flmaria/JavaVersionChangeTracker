package io.github.flmaria.java_010.localvariabletype;

import java.util.ArrayList;

public class Main {

    //var keyword to declare local variables with inferred types

    public static void main(String[] args) {
        var message = "Hello, World!"; // Inferred as String
        var count = 10;                // Inferred as int

        var list = new ArrayList<String>(); // Inferred as ArrayList<String>
        list.add("hello");

        for (var item : list) {
            System.out.println(item);
        }
    }

}
