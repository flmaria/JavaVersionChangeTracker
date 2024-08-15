package io.github.flmaria.java_009.processhandle;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {

        // Start a new process (using `open` to launch TextEdit on macOS)
        ProcessBuilder processBuilder = new ProcessBuilder("open", "-a", "TextEdit");

        try {
            Process process = processBuilder.start();
            ProcessHandle processHandle = process.toHandle();

            // Print Process ID
            System.out.println("Process ID: " + processHandle.pid());

            // Print Process Parent (if any)
            processHandle.parent().ifPresent(parent ->
                    System.out.println("Parent Process ID: " + parent.pid())
            );

            // Get process info
            ProcessHandle.Info info = processHandle.info();

            // Print process information
            System.out.println("Command: " + info.command().orElse("Unknown"));
            System.out.println("Arguments: " + String.join(" ", info.arguments().orElse(new String[0])));
            System.out.println("Start Time: " + info.startInstant().map(Instant::toString).orElse("Unknown"));
            System.out.println("User: " + info.user().orElse("Unknown"));
            System.out.println("CPU Time: " + info.totalCpuDuration().map(Duration::toString).orElse("Unknown"));

            //Wait for process to exit
            processHandle.onExit().thenAccept(ph ->
                    System.out.println("Process " + ph.pid() + " has exited.")
            );

            // Terminate the process
            processHandle.destroy();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
