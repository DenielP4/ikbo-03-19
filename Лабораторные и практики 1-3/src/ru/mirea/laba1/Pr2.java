package ru.mirea.laba1;

public class Pr2 {
    public static void main(String[] args) {
        int[] b= new int[5];
        b[1]=23;b[2]=3;b[3]=56;b[4]=277;b[0] = 123;
        System.out.println("Аргументы командной строки:");
        for (int i=0;i<5;i++) {
            System.out.println(" " + b[i]);
        }
    }
}
