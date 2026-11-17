/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.Scanner;
/**
 *
 * Проверить, чередуются ли в массиве чётные и нечётные числа. Если да, вывести 0, иначе — номер первого элемента, нарушающего закономерность.
 */
public class pr3_2 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Введите элементы массива через пробел: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Результат проверки: " + checkAlternation(arr));
        
        scanner.close();
    }

    public static int checkAlternation(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }

        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i] % 2) == Math.abs(array[i - 1] % 2)) {
                return i;
            }
        }

        return 0;
    }
}