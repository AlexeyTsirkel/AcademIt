package ru.academits.tsirkel.range.Main;

import ru.academits.tsirkel.range.Range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range firstRange = new Range(1, 3);
        double from = firstRange.getFrom();
        System.out.println("Начальное число первого диапазона: " + from);
        double to = firstRange.getTo();
        System.out.println("Конечное число первого диапазона: " + to);
        double rangeLength = firstRange.getLength();
        System.out.println("Длина первого диапазона = " + rangeLength);
        System.out.println(firstRange);

        System.out.println();

        System.out.println("Введите произвольное число для проверки:");
        double userNumber = scanner.nextDouble();
        boolean isInside = firstRange.isInside(userNumber);
        if (isInside) {
            System.out.println("Число входит в диапазон");
        } else {
            System.out.println("Число не входит в диапазон");
        }

        System.out.println();

        Range secondRange = new Range(0, 1);
        System.out.println("Введите начальное число второго диапазона:");
        secondRange.setFrom(scanner.nextDouble());
        System.out.println("Введите конечное число второго диапазона:");
        secondRange.setTo(scanner.nextDouble());
        System.out.println("Длина второго диапазона = " + rangeLength);
        System.out.println(secondRange);

        System.out.println();

        System.out.println("Пересечение двух диапазонов: " + firstRange.getIntersection(secondRange));
        System.out.println("Объединение двух диапазонов: " + Arrays.toString(firstRange.getUnion(secondRange)));
        System.out.println("Разность двух диапазонов: " + Arrays.toString(firstRange.getComplement(secondRange)));
    }
}
