package ru.academits.tsirkel.shapes.Comparators;

import ru.academits.tsirkel.shapes.Shapes.Shape;

import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shape> {

    @Override
    public int compare(Shape obj1, Shape obj2) {
        Double perimeter1 = obj1.getPerimeter();
        Double perimeter2 = obj2.getPerimeter();

        return perimeter1 > perimeter2 ? 1 : perimeter1 < perimeter2 ? -1 : 0;
    }
}
