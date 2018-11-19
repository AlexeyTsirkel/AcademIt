package ru.academits.tsirkel.vector.main;

import java.util.Scanner;

import ru.academits.tsirkel.vector.vector.*;

public class Main {
    public static void main(String[] args) {
        double[] arr = {-5, 0, 1, 2, 4, 7};
        double[] arr2 = {-3, 1, 3, 6, 11};
        System.out.println("Тестовая программа:");
        System.out.println();

        Vector vector1 = new Vector(arr);
        System.out.println("Вектор 1 = " + vector1 + ", размерностью " + vector1.getSize());
        System.out.println();

        System.out.println("Введите размерность 2 вектора: ");
        Scanner scanner = new Scanner(System.in);
        Vector vector2 = new Vector(scanner.nextInt());
        System.out.println("Вектор 2 = " + vector2);
        System.out.println();

        Vector vector3 = new Vector(vector1);
        System.out.println("Вектор 3 = " + vector3 + ", размерностью " + vector3.getSize());
        System.out.println();

        System.out.println("Введите размерность 4 вектора: ");
        Vector vector4 = new Vector(scanner.nextInt(), arr);
        System.out.println("Вектор 4 = " + vector4);
        System.out.println();

        Vector vector5 = new Vector(arr2);
        System.out.println("Вектор 5 = " + vector5);
        System.out.println();

        System.out.println("Нестатические методы:");
        System.out.println("Прибавляем к вектору 5 вектор 4: " + vector5.addVector(vector4));
        System.out.println();

        System.out.println("Вычитаем из вектора 5 вектор 1 = " + vector5.subtractVector(vector1));
        System.out.println();

        System.out.println("Введите число для умножения: ");
        System.out.println("Умножаем вектор 5 на число = " + vector5.multiplyVector(scanner.nextInt()));
        System.out.println();

        System.out.println("Разворот вектора 5: " + vector5.turnVector());
        System.out.println();

        System.out.println("Длина вектора 5 = " + vector5.getLength());
        System.out.println();

        System.out.println("Введите номер индекса:");
        int index = scanner.nextInt();
        System.out.println("Установка компоненты \"7\" по индексу " + index + " вектора 5: " + vector5.setComponent(index, 7));
        System.out.println();

        System.out.println("Введите номер индекса:");
        index = scanner.nextInt();
        System.out.println("Получение компоненты по индексу " + index + " вектора 5: " + vector5.getComponent(index));
        System.out.println();

        System.out.println("Сравним вектор 1 и вектор 4: ");
        System.out.println(vector1.equals(vector4));
        System.out.println();

        System.out.println("Статические методы:");
        Vector vector6 = new Vector(Vector.addVectorStatic(vector1, vector4));
        System.out.println("Сложение двух векторов (1 и 4)= " + vector6);

        Vector vector7 = new Vector(Vector.subtractVectorStatic(vector1, vector5));
        System.out.println("Вычитание двух векторов (1 и 5)= " + vector7);

        System.out.println("Скалярное произведение веторов (6 и 7): " + Vector.scalarMultiply(vector6, vector7));
    }
}
