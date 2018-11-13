package ru.academits.tsirkel.shapes.Shapes;

public class Circle implements Shape {
    private double radius;
    private static double PI = 3.1415;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle: radius = " + radius + ", width = " + getWidth() + ", height = " + getHeight()
                + ", area = " + getArea() + ", perimeter = " + getPerimeter() + ";";
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Circle circle = (Circle) object;
        return radius == circle.radius;
    }
}
