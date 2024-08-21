package io.github.flmaria.java_017.contextspecificdeserializationfilters;

import java.io.*;


public class Main {

    public static void main(String[] args) {
        // Define a context-specific filter
        ObjectInputFilter filter = ObjectInputFilter.Config.createFilter("maxdepth=5;maxrefs=100;*");

        // Apply the filter to an ObjectInputStream
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.obj"))) {
            ois.setObjectInputFilter(filter);
            Object obj = ois.readObject();
            System.out.println("Deserialized object: " + obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
