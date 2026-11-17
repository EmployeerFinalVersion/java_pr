package com.mycompany.main;
import java.util.Scanner;

public class pr1_3 {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите три числа (через Enter)");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double z = scanner.nextDouble();

        double middle;

        if ((x <= y && y <= z ) || (z <= y && y <= x )){
            middle = y;
        }
        else if ((y <= x && x <= z ) || (z <= x && x <= y )){
            middle = x;
        }
        else {
            middle = z;
        }
        System.out.println("Middle is " + middle);
    }
}
