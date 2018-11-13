package ru.academits.tsirkel.shapes.Shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private double getMin(double first, double second, double third) {
        double min;
        if (first <= second) {
            min = first;
        } else {
            min = second;
        }
        if (min < third) {
            return min;
        } else {
            return third;
        }
    }

    private double getMax(double first, double second, double third) {
        double max;
        if (first >= second) {
            max = first;
        } else {
            max = second;
        }
        if (max > third) {
            return max;
        } else {
            return third;
        }
    }

    private double getSideLength(double xFirst, double xSecond, double yFirst, double ySecond) {
        return Math.sqrt(Math.pow((xSecond - xFirst), 2) + Math.pow((ySecond - yFirst), 2));
    }

    @Override
    public double getWidth() {
        return getMax(x1, x2, x3) - getMin(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return getMax(y1, y2, y3) - getMin(y1, y2, y3);
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, x2, y1, y2) + getSideLength(x2, x3, y2, y3) + getSideLength(x1, x3, y1, y3);
    }

    public double getArea() {
        return Math.abs(0.5 * ((x1 - x3) * (y2 - y3) - (y1 - y3) * (x2 - x3)));
    }

    @Override
    public String toString() {
        return "Triangle: (x1, y1) = (" + x1 + "," + y1 + "), (x2, y2) = (" + x2 + "," + y2 + "), (x3, y3) = (" + x3 + "," + y3 + ")"
                + ", width = " + getWidth() + ", height = " + getHeight()
                + ", area = " + getArea() + ", perimeter = " + getPerimeter() + ";";
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
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
        Triangle triangle = (Triangle) object;
        return x1 == triangle.x1 && x2 == triangle.x2 && x3 == triangle.x3 && y1 == triangle.y1 && y2 == triangle.y2 && y3 == triangle.y3;
    }
}
