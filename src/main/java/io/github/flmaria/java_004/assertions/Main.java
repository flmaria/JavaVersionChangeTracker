package io.github.flmaria.java_004.assertions;

public class Main {

    public static void main(String[] args) {
        int number = 5;
        assert number > 0 : "Number should be positive";

        number = -10;
        assert number > 0 : "Number should be positive, but found " + number;

        System.out.println("Program completed successfully.");
    }

}
