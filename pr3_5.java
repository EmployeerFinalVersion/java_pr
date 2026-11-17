/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Scanner;

/**
 Доработать программу из лабораторной работы №2:
 * применить массивы для хранения параметров вычисления и передачи данных между статическими методами;
 * выделить методы ввода, вычисления, вывода и проверки;
 * сохранить меню и обработку ошибок.
 */
public class pr3_5 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> runCalculationProcess(scanner);
                case "2" -> printProgramInfo();
                case "3" -> printDeveloperInfo();
                case "4" -> {
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Некорректный пункт меню. Попробуйте снова.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
        System.out.println("1. Выполнить расчёт");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
        System.out.print("Выберите пункт: ");
    }

    public static void runCalculationProcess(Scanner scanner) {
        double[] params = new double[3];

        if (!inputData(scanner, params)) {
            return;
        }

        calculateBMI(params);

        printResults(params);
    }

    public static boolean inputData(Scanner scanner, double[] params) {
        double weight = readPositiveDouble(scanner, "Введите ваш вес в килограммах (или 'exit' для выхода): ");
        if (Double.isNaN(weight)) return false;

        double height = readPositiveDouble(scanner, "Введите ваш рост в метрах (или 'exit' для выхода): ");
        if (Double.isNaN(height)) return false;

        params[0] = weight;
        params[1] = height;
        return true;
    }

    public static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Возврат в главное меню.");
                return Double.NaN;
            }

            try {
                double value = Double.parseDouble(input);
                if (validatePositive(value)) {
                    return value;
                } else {
                    System.out.println("Значение должно быть положительным.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Введите число или 'exit'.");
            }
        }
    }

    public static boolean validatePositive(double value) {
        return value > 0;
    }

    public static void calculateBMI(double[] params) {
        double weight = params[0];
        double height = params[1];
        params[2] = weight / (height * height);
    }

    public static void printResults(double[] params) {
        double bmi = params[2];
        System.out.printf("Ваш ИМТ: %.2f%n", bmi);
        System.out.println("Категория: " + getBmiCategory(bmi));
    }

    public static String getBmiCategory(double bmi) {
        if (bmi < 18.5) {
            return "недостаточная масса тела";
        } else if (bmi < 25) {
            return "нормальная масса тела";
        } else if (bmi < 30) {
            return "избыточная масса тела";
        } else {
            return "ожирение";
        }
    }

    public static void printProgramInfo() {
        System.out.println("\nПрограмма вычисляет индекс массы тела (ИМТ) и определяет категорию массы тела.");
    }

    public static void printDeveloperInfo() {
        System.out.println("\nРазработчик: Ходченко А.А.");
    }
}
