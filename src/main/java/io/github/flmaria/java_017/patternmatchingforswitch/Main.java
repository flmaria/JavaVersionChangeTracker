package io.github.flmaria.java_017.patternmatchingforswitch;

public class Main {

    public static void main(String[] args) {

        //@TODO: update local jdk to 21: this code is not compiling
        Object obj = "Hello, Java 17!";

        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            case Double d -> "Double: " + d;
            case null -> "It's null";
            default -> "Unknown type";
        };

        System.out.println(result);

    }

}
