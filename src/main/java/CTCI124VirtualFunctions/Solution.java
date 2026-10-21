package CTCI124VirtualFunctions;

import java.util.List;

public class Solution {

    public abstract static class Shape {
        public abstract double area();

        public String name() {
            // TODO: Implement CTCI 12.4 Virtual Functions
            throw new UnsupportedOperationException("TODO: CTCI 12.4 Virtual Functions");
        }

        public String describe() {
            throw new UnsupportedOperationException("TODO: CTCI 12.4 Virtual Functions");
        }

        public static String staticName() {
            throw new UnsupportedOperationException("TODO: CTCI 12.4 Virtual Functions");
        }
    }

    public static class Circle extends Shape {
        public Circle(double radius) {
            // TODO
        }

        @Override
        public double area() {
            throw new UnsupportedOperationException("TODO: CTCI 12.4 Virtual Functions");
        }

        public static String staticName() {
            throw new UnsupportedOperationException("TODO: CTCI 12.4 Virtual Functions");
        }
    }

    public static class Square extends Shape {
        public Square(double side) {
            // TODO
        }

        @Override
        public double area() {
            throw new UnsupportedOperationException("TODO: CTCI 12.4 Virtual Functions");
        }

        public static String staticName() {
            throw new UnsupportedOperationException("TODO: CTCI 12.4 Virtual Functions");
        }
    }

    static List<String> describeAll(List<Shape> shapes) {
        throw new UnsupportedOperationException("TODO: CTCI 12.4 Virtual Functions");
    }
}
