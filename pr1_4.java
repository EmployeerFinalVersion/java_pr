package com.mycompany.main;

import java.util.Scanner;

public class pr1_4 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш вес в килограммах: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Вес должен быть числом");
            return;
        }
        double weight = scanner.nextDouble();

        System.out.print("Введите ваш рост в метрах: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Рост должен быть числом.");
            return;
        }
        double height = scanner.nextDouble();

        if (weight <= 0 || height <= 0) {
            System.out.println("Вес и рост должны быть положительными");
            return;
        }

        double bmi = weight / (height * height);

        System.out.printf("Ваш ИМТ: %.2f%n", bmi);

        if (bmi < 18.5) {
            System.out.println("Категория: недостаточная масса тела");
        } else if (bmi < 25) {
            System.out.println("Категория: нормальная масса тела");
        } else if (bmi < 30) {
            System.out.println("Категория: избыточная масса тела");
        } else {
            System.out.println("Категория: ожирение");
        }
    }
}