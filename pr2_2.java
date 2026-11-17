/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Scanner;

/**
 *
 * Дано вещественное число A и целое число N (> 0). Используя один цикл, найти сумму: A + A^2 + A^3 + ... + A^N
 */
public class pr2_2 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Введите вещественное число A: ");
        double a = scanner.nextDouble();

        System.out.print("Введите целое число N (>0): ");
        int n = scanner.nextInt();

        
        if (n <= 0) {
            System.out.println("Ошибка: N должно быть больше 0.");
            return;
        }

        double sum = 0;
        double currentPower = 1;

        for (int i = 1; i <= n; i++) {
            currentPower *= a;
            sum += currentPower;
        }

        System.out.printf("Сумма равна: %.4f%n", sum);
    }
}
