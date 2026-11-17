/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * Вывести таблицу косинусов в формате cos(x)=y , где x [0;90], с шагом 5
 */
public class pr2_1 {
    static void main() {
        for (int x = 0; x <= 90; x += 5) {
            double radians = Math.toRadians(x);
            
            double y = Math.cos(radians);
            
            System.out.printf("cos(%d)=%.4f%n", x, y);
        }
    }
}
