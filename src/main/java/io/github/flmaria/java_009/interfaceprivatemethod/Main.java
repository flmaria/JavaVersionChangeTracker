package io.github.flmaria.java_009.interfaceprivatemethod;

public class Main {

    public static void main(String args[]) {

        /**
         * Java 9: Private methods in Interfaces
         * It can be used by "default" interface methods, static interface methods and other private interface methods.
         *
         * Obs: You can also create private static methods in Interface
         *
         */

        Calculator calculator = new CalculatorImpl();

        System.out.println("Addition: " + calculator.add(2, 3)); //Default method in Interface that calls private interface method
        System.out.println("Subtraction: " + Calculator.subtract(2, 7)); //Static method in Interface that calls private interface method
        System.out.println("Multiplication: " + calculator.multiply(3, 4)); //Default method in Interface that calls private interface method and this private method calls another Interface private method


    }


}
