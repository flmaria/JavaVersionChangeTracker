package io.github.flmaria.java_014.records;

public class Main {

    public static void main(String[] args) {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);

        System.out.println(point1);  // Outputs: Point[x=3, y=4]
        System.out.println(point1.equals(point2));  // Outputs: true
        System.out.println(point1.hashCode());  // Consistent with equals()
    }

}
