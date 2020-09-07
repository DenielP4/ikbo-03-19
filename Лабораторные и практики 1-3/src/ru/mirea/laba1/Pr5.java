package ru.mirea.laba1;
import java.util.Scanner;

public class Pr5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число факториал которого вам нужен");
        int a = sc.nextInt();
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }
        System.out.println(result);
    }
}
