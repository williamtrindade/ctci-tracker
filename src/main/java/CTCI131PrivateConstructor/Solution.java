package CTCI131PrivateConstructor;

public class Solution {

    public abstract static class Shape {
        public Shape() {
            // TODO: Implement CTCI 13.1 Private Constructor (este construtor deve ser privado)
        }

        public abstract double area();

        public static Shape circle(double radius) {
            throw new UnsupportedOperationException("TODO: CTCI 13.1 Private Constructor");
        }

        public static Shape square(double side) {
            throw new UnsupportedOperationException("TODO: CTCI 13.1 Private Constructor");
        }

        public static class Circle extends Shape {
            public Circle(double radius) {
                // TODO
            }

            @Override
            public double area() {
                throw new UnsupportedOperationException("TODO: CTCI 13.1 Private Constructor");
            }
        }

        public static class Square extends Shape {
            public Square(double side) {
                // TODO
            }

            @Override
            public double area() {
                throw new UnsupportedOperationException("TODO: CTCI 13.1 Private Constructor");
            }
        }
    }

    public static class Registry {
        public Registry() {
            // TODO: Implement CTCI 13.1 Private Constructor (este construtor deve ser privado)
        }

        public static Registry getInstance() {
            throw new UnsupportedOperationException("TODO: CTCI 13.1 Private Constructor");
        }
    }
}
