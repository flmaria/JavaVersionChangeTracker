package io.github.flmaria.java_005.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in); // Reading from standard input
        Scanner fileScanner = new Scanner(new File("input.txt")); // Reading from a file
        Scanner stringScanner = new Scanner("1 2 3 4 5"); // Reading from a string

        //---

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        System.out.print("Enter a floating-point number: ");
        double decimal = scanner.nextDouble();

        //---

        System.out.print("Enter your name: ");
        String name = scanner.next(); // Reads a single word

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine(); // Reads the entire line

        //--

        scanner.useDelimiter(","); // Use comma as the delimiter
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        //--

        if (scanner.hasNextInt()) {
            int number2 = scanner.nextInt();
        } else {
            System.out.println("Input is not an integer.");
        }

        try {
            int number3 = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }



    }

}
