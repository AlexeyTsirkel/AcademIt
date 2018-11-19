package ru.academits.tsirkel.arraylisthome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("../ArrayListHome//input.txt"))) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        }
        System.out.println("Все строки из файла:");
        for (int i = 0; i < lines.size(); ++i) {
            System.out.println("Строка " + (i + 1) + ": " + lines.get(i));
        }
        System.out.println();

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("Список без четных чисел:");
        numbers.removeIf(n -> (n % 2 == 0));
        for (Integer n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println("\n");

        ArrayList<Integer> repNumbers = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 7, 1, 2, 8, 6, 3, 1));
        System.out.println("Второй список без повторений: ");
        ArrayList<Integer> newNumbers = new ArrayList<>(repNumbers);
        for (int i = 0; i < newNumbers.size(); ++i) {
            for (int j = i + 1; j < newNumbers.size(); ++j) {
                if (newNumbers.get(i).equals(newNumbers.get(j))) {
                    newNumbers.remove(j);
                    j--;
                }
            }
            System.out.print(newNumbers.get(i) + " ");
        }
    }
}
