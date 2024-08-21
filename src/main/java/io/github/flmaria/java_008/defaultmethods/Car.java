package io.github.flmaria.java_008.defaultmethods;

public class Car implements Vehicle {
    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }
}
