package io.github.flmaria.java_009.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));

            // Use the resource in try-with-resources without redeclaring it
            try (reader) {
                System.out.println(reader.readLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
