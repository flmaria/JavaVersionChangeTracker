package io.github.flmaria.java_004.regularexpressions;

import java.util.regex.*;


public class Main {

    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog.";

        // Compile the regular expression
        Pattern pattern = Pattern.compile("\\b\\w{4}\\b"); // Matches words with exactly 4 letters

        // Create a matcher to find occurrences in the input string
        Matcher matcher = pattern.matcher(input);

        // Find and display all matching words
        while (matcher.find()) {
            System.out.println("Found a 4-letter word: " + matcher.group());
        }

        // Replace all 4-letter words with '****'
        String replaced = matcher.replaceAll("****");
        System.out.println("Modified string: " + replaced);
    }

}
