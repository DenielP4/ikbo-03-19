package ru.mirea.laba3.dish;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Plate plate=new Plate(in.nextInt());
        Fork fork=new Fork(in.nextInt());
        System.out.println("Тарелка разбита?\n-"+plate.is_broken+"\nВилка разбита?\n-" +fork.is_broken);
        System.out.println("Вес:\n\tТарелка\t"+plate.weight+"\n\tВилка\t"+ fork.weight);
        System.out.println("*разбиваем посуду*");
        plate.Smash();
        fork.Smash();
        System.out.println("Тарелка разбита?\n-"+plate.is_broken+"\nВилка разбита?\n-" +fork.is_broken);
    }
}
