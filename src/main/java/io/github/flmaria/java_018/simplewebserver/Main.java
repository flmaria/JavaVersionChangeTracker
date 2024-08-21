package io.github.flmaria.java_018.simplewebserver;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.IOException;

public class Main {

    /*
    The Simple Web Server introduced in Java 18 is a lightweight, easy-to-use tool designed primarily for development, prototyping, and educational purposes.
    It offers a straightforward way to serve static files and handle basic HTTP requests without the need for complex configuration or dependencies.
    While it's not intended for production use, its simplicity makes it a valuable tool for many scenarios.


    A simple example of how to start the Simple Web Server from the command line:
    java -m jdk.httpserver --directory /my/website --port 8080

     */

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", exchange -> {
            String response = "Hello, World!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close();
        });
        server.start();
    }

}
