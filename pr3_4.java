/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.Scanner;
/**
 *
 * Для квадратной матрицы нечётного порядка вывести элементы по спирали по часовой стрелке, начиная с A1,1, последним вывести центральный элемент.
 */
public class pr3_4 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер матрицы: ");
        int n = scanner.nextInt();
        
        int[][] matrix = new int[n][n];

        System.out.println("Введите элементы матрицы построчно (через пробел):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Вывод элементов по спирали:");
        printSpiral(matrix);

        scanner.close();
    }

    public static void printSpiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int n = matrix.length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }
}
