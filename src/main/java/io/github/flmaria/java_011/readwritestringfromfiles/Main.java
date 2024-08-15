package io.github.flmaria.java_011.readwritestringfromfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            // Define the file path
            Path path = Paths.get("example.txt");

            // Write a string to the file
            String contentToWrite = "This is a sample text for Java 11 File I/O!";
            Files.writeString(path, contentToWrite);
            System.out.println("File written successfully.");

            // Read the string from the file
            String contentRead = Files.readString(path);
            System.out.println("Content read from file:");
            System.out.println(contentRead);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

