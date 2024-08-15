package io.github.flmaria.java_011.stringmethods;

public class Main {

    public static void main(String[] args) {

        //isBlank() - This method returns true if the string is empty or contains only whitespace characters.

        String str = "  ";
        System.out.println(str.isBlank());

//        strip() - This method removes leading and trailing whitespace from a string. It's similar to trim(), but it also handles Unicode whitespace correctly.
        String str2 = "  hello  ";
        System.out.println(str2.strip());

        //stripLeading() - This method removes leading whitespace from a string.
        String str3 = "  hello  ";
        System.out.println(str3.stripLeading());

        //stripTrailing - This method removes trailing whitespace from a string.
        String str4 = "  hello  ";
        System.out.println(str4.stripTrailing());

        //repeat(int n) - Description: This method returns a new string which is the original string repeated n times.
        String str5 = "hello";
        System.out.println(str5.repeat(3));

        //lines() - This method returns a Stream<String> of all the lines in the string, separated by line terminators.
        String str6 = "hello\nworld";
        str6.lines().forEach(System.out::println);

        //indent(int n) - This method adjusts the indentation of each line in the string by adding or removing spaces.
        String str7 = "hello\nworld";
        System.out.println(str7.indent(4));

        //transform(Function<? super String,? extends R> f) - This method applies a function to the string and returns the result. It allows you to chain string manipulations in a more functional style.
        String str8 = "hello";
        String result = str8.transform(s -> s.toUpperCase());
        System.out.println(result);

        //chars() - This method returns an IntStream of the characters in the string.
        String str9 = "hello";
        str9.chars().forEach(ch -> System.out.print((char) ch));


    }

}
