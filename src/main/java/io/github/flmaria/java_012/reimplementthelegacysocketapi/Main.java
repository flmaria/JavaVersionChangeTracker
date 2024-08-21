package io.github.flmaria.java_012.reimplementthelegacysocketapi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
            int port = 1234;

            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Server is listening on port " + port);

                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected");

                    // Create input and output streams for the socket
                    InputStream input = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);

                    // Read a message from the client and send a response
                    String message = reader.readLine();
                    System.out.println("Received from client: " + message);
                    writer.println("Hello, client! You sent: " + message);

                    // Close the socket
                    socket.close();
                }

            } catch (IOException ex) {
                System.out.println("Server exception: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

}
