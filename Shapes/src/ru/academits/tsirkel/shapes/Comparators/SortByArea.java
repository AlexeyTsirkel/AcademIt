package ru.academits.tsirkel.shapes.Comparators;

import ru.academits.tsirkel.shapes.Shapes.Shape;

import java.util.Comparator;

public class SortByArea implements Comparator<Shape> {

    @Override
    public int compare(Shape obj1, Shape obj2) {
        Double area1 = obj1.getArea();
        Double area2 = obj2.getArea();

        return area1 > area2 ? 1 : area1 < area2 ? -1 : 0;
    }
}

