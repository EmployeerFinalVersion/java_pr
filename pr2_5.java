/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/*
Доработайте программу из лабораторной работы 1:
1. добавьте главное меню на основе цикла while: выполнить расчёт, информация о программе, информация о разработчике, выход;
2. при ошибочном вводе предлагайте повторить ввод до получения корректных данных или команды выхода;
3. выполните декомпозицию программы и реализуйте статические методы для отдельных частей.
*/

import java.util.Scanner;

public class pr2_5 {

    private static final String EXIT_COMMAND = "exit";

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("=== Добро пожаловать в Кредитный калькулятор ===");

        while (isRunning) {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    performCalculationFlow(scanner);
                    break;
                case "2":
                    printProgramInfo();
                    break;
                case "3":
                    printDeveloperInfo();
                    break;
                case "4":
                    System.out.println("Завершение работы программы. До свидания!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Ошибка: неверный пункт меню. Пожалуйста, выберите 1, 2, 3 или 0.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n------------------ ГЛАВНОЕ МЕНЮ ------------------");
        System.out.println("1. Выполнить расчёт");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
        System.out.println("--------------------------------------------------");
    }

    private static void printProgramInfo() {
        System.out.println("\n--- Информация о программе ---");
        System.out.println("Программа предназначена для расчёта платежа по кредиту.");
        System.out.println("Используемая формула: P = S * (i * (1 + i)^n) / ((1 + i)^n - 1),");
        System.out.println("где S — сумма кредита, i — месячная ставка, n — срок в месяцах.");
    }

    private static void printDeveloperInfo() {
        System.out.println("\n--- Информация о разработчике ---");
        System.out.println("Разработчик: Ходченко А.А.");
    }

    private static void performCalculationFlow(Scanner scanner) {
        System.out.println("\n--- Расчёт кредита (для возврата в меню введите '" + EXIT_COMMAND + "') ---");

        Double loanAmount = readValidDouble(scanner, "Введите сумму кредита (в рублях): ", 1.0, 1_000_000_000.0);
        if (loanAmount == null) {
            System.out.println("Расчёт отменён пользователем.");
            return;
        }

        Double annualRate = readValidDouble(scanner, "Введите годовую процентную ставку (в %): ", 0.01, 1000.0);
        if (annualRate == null) {
            System.out.println("Расчёт отменён пользователем.");
            return;
        }

        Integer months = readValidInt(scanner, "Введите срок кредита (в месяцах): ", 1, 600);
        if (months == null) {
            System.out.println("Расчёт отменён пользователем.");
            return;
        }

        double monthlyPayment = calculateMonthlyPayment(loanAmount, annualRate, months);
        printCalculationResults(loanAmount, monthlyPayment, months);
    }

    private static Double readValidDouble(Scanner scanner, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().replace(',', '.');

            if (input.equalsIgnoreCase(EXIT_COMMAND)) {
                return null;
            }

            try {
                double value = Double.parseDouble(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Ошибка: значение должно быть в диапазоне от %.2f до %.2f. Попробуйте снова или введите '%s'.%n", min, max, EXIT_COMMAND);
            } catch (NumberFormatException e) {
                System.out.printf("Ошибка: введено не число. Попробуйте снова или введите '%s'.%n", EXIT_COMMAND);
            }
        }
    }

    private static Integer readValidInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase(EXIT_COMMAND)) {
                return null;
            }

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Ошибка: значение должно быть целым числом от %d до %d. Попробуйте снова или введите '%s'.%n", min, max, EXIT_COMMAND);
            } catch (NumberFormatException e) {
                System.out.printf("Ошибка: введено не целое число. Попробуйте снова или введите '%s'.%n", EXIT_COMMAND);
            }
        }
    }

    private static double calculateMonthlyPayment(double loanAmount, double annualRate, int months) {
        double monthlyRate = (annualRate / 100.0) / 12.0;
        double factor = Math.pow(1 + monthlyRate, months);
        return loanAmount * (monthlyRate * factor) / (factor - 1);
    }

    private static void printCalculationResults(double loanAmount, double monthlyPayment, int months) {
        double totalPayment = monthlyPayment * months;
        double overpayment = totalPayment - loanAmount;

        System.out.println("--------------------------------------------------");
        System.out.println("Результаты расчёта:");
        System.out.printf("Ежемесячный платёж: %.2f руб.%n", monthlyPayment);
        System.out.printf("Общая сумма выплат: %.2f руб.%n", totalPayment);
        System.out.printf("Итоговая переплата: %.2f руб.%n", overpayment);
        System.out.println("--------------------------------------------------");
    }
}
