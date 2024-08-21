package io.github.flmaria.java_013.filesystemsnewfilesystemmethod;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Collections;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Path to the ZIP file
        Path zipFilePath = Paths.get("example.zip");

        // URI scheme "jar" is used for accessing ZIP files as file systems
        URI uri = URI.create("jar:" + zipFilePath.toUri());

        // Environment map to configure the file system, usually empty for ZIP files
        Map<String, String> env = Collections.emptyMap();

        // Create and use the ZIP file system
        try (FileSystem zipFileSystem = FileSystems.newFileSystem(uri, env)) {
            // Get a path within the ZIP file system
            Path zipEntryPath = zipFileSystem.getPath("/example.txt");

            // Read the file within the ZIP
            String content = Files.readString(zipEntryPath);
            System.out.println("Content of example.txt: " + content);

            // Perform other file operations like creating directories, writing files, etc.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
