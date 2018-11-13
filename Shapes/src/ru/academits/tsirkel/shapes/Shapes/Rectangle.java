package ru.academits.tsirkel.shapes.Shapes;

public class Rectangle implements Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    public String toString() {
        return "Rectangle: width = " + getWidth() + ", height = " + getHeight()
                + ", area = " + getArea() + ", perimeter = " + getPerimeter() + ";";
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(height);
        hash = prime * hash + Double.hashCode(width);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) object;
        return height == rectangle.height && width == rectangle.width;
    }
}
