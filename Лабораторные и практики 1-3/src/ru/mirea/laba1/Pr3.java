package ru.mirea.laba1;

public class Pr3 {
    public static void main(String[] args) {
        int[] b= new int[5];
        double n =1 ;
        double k =2;

        for (int i=0;i<10;i++) {
            System.out.print(""+n);
            n = n + (1 / k);
            k++;
        }
    }
}
