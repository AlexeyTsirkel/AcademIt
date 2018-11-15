package ru.academits.tsirkel.shapes.Main;

import ru.academits.tsirkel.shapes.Shapes.*;
import ru.academits.tsirkel.shapes.Comparators.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Shape[] shape = new Shape[]{new Circle(5),
                new Circle(8),
                new Square(4),
                new Square(9),
                new Rectangle(6, 11),
                new Triangle(2, 2, 8, 8, 10, 2)};

        Arrays.sort(shape, new SortByAreaComparator());
        System.out.println("Фигура с наибольшей площадью - " + shape[shape.length - 1]);

        System.out.println();

        Arrays.sort(shape, new SortByPerimeterComparator());
        System.out.println("Фигура со вторым по величине периметром - " + shape[shape.length - 2]);
    }
}
