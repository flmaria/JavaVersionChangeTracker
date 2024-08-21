package io.github.flmaria.java_008.defaultmethods;

public interface Vehicle {

    default void start() {
        System.out.println("Starting vehicle...");
    }

    void stop();

}
