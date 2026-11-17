/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Даны отсортированные по возрастанию массивы A и B размера N. Объединить их в отсортированный массив C размера 2N. Реализовать отдельным статическим методом.
 */
public class pr3_3 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер первого массива (A): ");
        int sizeA = scanner.nextInt();
        int[] A = new int[sizeA];
        System.out.print("Введите элементы массива A через пробел: ");
        for (int i = 0; i < sizeA; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.print("Введите размер второго массива (B): ");
        int sizeB = scanner.nextInt();
        int[] B = new int[sizeB];
        System.out.print("Введите элементы массива B через пробел: ");
        for (int i = 0; i < sizeB; i++) {
            B[i] = scanner.nextInt();
        }

        int[] C = mergeSortedArrays(A, B);
        System.out.print("Результат слияния: ");
        System.out.println(Arrays.toString(C));

        scanner.close();
    }

    public static int[] mergeSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[2 * n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < n) {
            if (A[i] <= B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        while (i < n) {
            C[k++] = A[i++];
        }

        while (j < n) {
            C[k++] = B[j++];
        }

        return C;
    }
}
