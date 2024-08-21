package io.github.flmaria.java_008.defaultmethods;



public class Main {

    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start(); // Outputs: Starting vehicle...
        car.stop();  // Outputs: Car stopped.

        Vehicle bike = new Bike();
        bike.start(); // Outputs: Starting vehicle...
        bike.stop();  // Outputs: Bike stopped.
    }

}
