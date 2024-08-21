package io.github.flmaria.java_014.patternmatchingforinstanceof;

public class Main {

    public static void main(String[] args) {

        //Before this feature

        Object obj = new Object();

         if (obj instanceof String) {
            String s = (String) obj;

            System.out.println(s.length());
        }

         //new feature

        Object obj2 = new Object();

        if (obj2 instanceof String s) {
            System.out.println("String length: " + s.length());
        } else if (obj2 instanceof Integer i) {
            System.out.println("Integer value: " + i);
        } else {
            System.out.println("Unknown type");
        }





    }

}
