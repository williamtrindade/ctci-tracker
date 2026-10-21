package CTCI136ObjectReflection;

public class Rectangle {
    private final double width;
    private final double height;
    private String secret = "s3cr3t";

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double scaledArea(double factor) {
        return area() * factor * factor;
    }
}
