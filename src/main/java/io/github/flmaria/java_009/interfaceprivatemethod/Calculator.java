package io.github.flmaria.java_009.interfaceprivatemethod;

public interface Calculator {

    default int add(int number1, int number2) {
        return this.sum(number1, number2);
    }

    static int subtract(int number1, int number2) {
        return difference(number1, number2);
    }

    default int multiply(int number1, int number2) {
        return this.product(number1, number2);
    }

    private int sum(int number1, int number2) {
        return number1 + number2;
    }

    private static int difference(int number1, int number2) {
        return number2 - number1;
    }

    private int product(int number1, int number2) {
        return this.dumbProduct(number1, number2);
    }

    /**
     * @OBS: Private method just created to demonstrate its usage by another Interface private method
     */
    private int dumbProduct(int number1, int number2) {
        return number1 * number2;
    }

}
