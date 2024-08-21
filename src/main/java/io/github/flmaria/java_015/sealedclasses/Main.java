package io.github.flmaria.java_015.sealedclasses;


public class Main {

    /*
    Definition of Sealed Classes:

    A sealed class or interface restricts which other classes or interfaces may extend or implement it.
    When you declare a class or interface as sealed, you must explicitly specify the subclasses or subinterfaces that are permitted to extend or implement it using the permits keyword.
    */

    public sealed class Shape permits Circle, Rectangle, Square {
        // Common properties and methods for all shapes
    }

    public final class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }
    }

    public final class Rectangle extends Shape {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }
    }

    public non-sealed class Square extends Shape {
        private final double side;

        public Square(double side) {
            this.side = side;
        }

        public double getSide() {
            return side;
        }
    }

}
