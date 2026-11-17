/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class pr2_3 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите вещественное число e (> 0): ");
        double eps = scanner.nextDouble();

        if (eps <= 0) {
            System.out.println("Ошибка: e должно быть строго больше 0");
            return;
        }

        int k = 2;
        double aPrev = 2.0; // A1
        double aCurr = 1.0 / aPrev; // A2

        while (Math.abs(aCurr - aPrev) >= eps) {
            aPrev = aCurr;
            aCurr = 1.0 / aPrev;
            k++;
            
        }

        System.out.println("\nРезультат:");
        System.out.println("Номер K = " + k);
        System.out.printf("A(K-1) = %.6f%n", aPrev);
        System.out.printf("A(K) = %.6f%n", aCurr);
        System.out.printf("Разность |A_K - A_{K-1}| = %.6f%n", Math.abs(aCurr - aPrev));
    }
}
