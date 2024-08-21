package io.github.flmaria.java_012.reimplementthelegacysocketapi;

import java.io.*;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(hostname, port)) {

            // Create input and output streams for the socket

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Send a message to the server
            writer.println("Hello, server!");

            // Read the server's response
            String response = reader.readLine();
            System.out.println("Received from server: " + response);

        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
