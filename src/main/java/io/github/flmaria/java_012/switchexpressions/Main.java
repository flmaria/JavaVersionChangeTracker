package io.github.flmaria.java_012.switchexpressions;

public class Main {

    public static void main(String[] args) {

        /** The enhanced switch can be used as an expression, meaning it can return a value.
         *  By default, switch expressions do not allow fall-through between cases. This eliminates the need for break statements, which are often a source of bugs in traditional switch statements.
         */

        String day = "MONDAY";
        int result = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            case "WEDNESDAY" -> 9;
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };

        System.out.println(result);

        //If a case block is more complex and involves multiple statements, you can use a block syntax that uses yield to return a value.
        int result2 = switch (day) {
            case "MONDAY" -> {
                System.out.println("Start of the week");
                yield 6;
            }
            case "FRIDAY" -> 6;
            case "WEDNESDAY" -> 9;
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };

        System.out.println(result2);

    }

}
