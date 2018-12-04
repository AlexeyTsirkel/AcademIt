package ru.academits.tsirkel.arraylisthome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("../ArrayListHome//input.txt"))) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл для чтения не найден!");
        }
        System.out.println("Все строки из файла:");
        for (int i = 0; i < lines.size(); ++i) {
            System.out.println("Строка " + (i + 1) + ": " + lines.get(i));
        }
        System.out.println();

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("Список без четных чисел:");
        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        ArrayList<Integer> repNumbers = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 7, 1, 2, 8, 6, 3, 1));
        System.out.println("Второй список без повторений: ");
        ArrayList<Integer> newNumbers = new ArrayList<>(repNumbers.size());
        for (Integer e : repNumbers) {
            if (!newNumbers.contains(e)) {
                newNumbers.add(e);
                System.out.print(newNumbers.get(newNumbers.indexOf(e)) + " ");
            }
        }
    }
}
