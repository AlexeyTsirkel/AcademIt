package ru.academits.tsirkel.shapes.Shapes;

public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getWidth() {
        return length;
    }

    @Override
    public double getHeight() {
        return length;
    }

    @Override
    public double getArea() {
        return Math.pow(length, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }

    @Override
    public String toString() {
        return "Square: length = " + length + ", width = " + getWidth() + ", height = " + getHeight()
                + ", area = " + getArea() + ", perimeter = " + getPerimeter() + ";";
    }

    @Override
    public int hashCode() {
        return Double.hashCode(length);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Square square = (Square) object;
        return length == square.length;
    }
}
