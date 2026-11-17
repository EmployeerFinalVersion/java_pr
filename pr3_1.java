/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Вывести сначала элементы с нечётными номерами по возрастанию, затем элементы с чётными номерами по убыванию. Условный оператор не использовать.
 */
public class pr3_1 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.print("Введите элементы массива через пробел: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        System.out.print("Исходный массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        int oddCount = (n + 1) / 2;
        int evenCount = n / 2;

        int[] odds = new int[oddCount];
        int[] evens = new int[evenCount];

        int oddIdx = 0;
        for (int i = 0; i < n; i += 2) {
            odds[oddIdx] = array[i];
            oddIdx++;
        }

        int evenIdx = 0;
        for (int i = 1; i < n; i += 2) {
            evens[evenIdx] = array[i];
            evenIdx++;
        }

        Arrays.sort(odds);
        Arrays.sort(evens);

        System.out.print("Нечётные номера по возрастанию: ");
        for (int i = 0; i < odds.length; i++) {
            System.out.print(odds[i] + " ");
        }
        System.out.println();

        System.out.print("Чётные номера по убыванию: ");
        for (int i = evens.length - 1; i >= 0; i--) {
            System.out.print(evens[i] + " ");
        }
        System.out.println();
        scanner.close();
    }
}
