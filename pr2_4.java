/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author User
 */
public class pr2_4 {
    public static void main() {
        System.out.println("Результат для 15.5:  " + getSign(15.5));
        System.out.println("Результат для 0.0:   " + getSign(0.0));
        System.out.println("Результат для -9.25: " + getSign(-9.25));
    }
    
    public static int getSign(double number) {
        return (number > 0) ? 1 : (number < 0) ? -1 : 0;
    }
}
