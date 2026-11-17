package com.mycompany.main;
import java.util.Scanner;

public class pr1_2 {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите x");
        double x = scanner.nextDouble();

        if (x <= 0){
            System.out.println("x должен быть больше нуля");
            return;
        }
        double y = func1(x);
        System.out.printf("y = %.2f%n", y);
    }

    public static double func1(double x){
        return Math.pow(x, 5) + Math.pow(Math.log(x), 3) + Math.sqrt(Math.pow(x, 3));
    }
}