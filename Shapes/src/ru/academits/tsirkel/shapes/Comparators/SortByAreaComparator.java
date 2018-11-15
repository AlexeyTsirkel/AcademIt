package ru.academits.tsirkel.shapes.Comparators;

import ru.academits.tsirkel.shapes.Shapes.Shape;

import java.util.Comparator;

public class SortByAreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape obj1, Shape obj2) {

        return Double.compare(obj1.getArea(), obj2.getArea());
    }
}

