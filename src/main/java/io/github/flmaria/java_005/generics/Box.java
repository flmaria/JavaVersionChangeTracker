package io.github.flmaria.java_005.generics;

// Example of a generic class
public class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}