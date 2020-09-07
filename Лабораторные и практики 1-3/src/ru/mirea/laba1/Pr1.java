package ru.mirea.laba1;

import java.util.Scanner;

public class Pr1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите число:");
            int a = sc.nextInt();
            m = m + a;
        }
        System.out.println("Сумма чисел c помощью массива for:" + m);


        Scanner nc = new Scanner(System.in);
        int s = 0;
        System.out.println("Введите количество чисел:");
        int a = nc.nextInt();
        while (a!=0){
            System.out.println("Введите число:");
            int g = nc.nextInt();
            s = s + g;
            a--;
        }

        System.out.println("Сумма чисел c помощью массива while:" + s);
        Scanner mc = new Scanner(System.in);
        int r = 0;
        System.out.println("Введите количество чисел:");
        int y = mc.nextInt();
        do {
            System.out.println("Введите число:");
            int as = mc.nextInt();
            r = r + as;
            y--;
        }while(y!=0);
        System.out.println("Сумма чисел c помощью массива do while:" + r);
    }
}
