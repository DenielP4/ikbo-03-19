package ru.mirea.laba3.dogs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Labrador labrador = new Labrador(in.next(), in.nextInt());
        Sheepdog sheepdog = new Sheepdog(in.next(), in.nextInt());
        System.out.println("Лабрадор: "+labrador.name+" "+labrador.age+"\n"+labrador.Woof());
        System.out.println("Овчарка: "+sheepdog.name+" "+sheepdog.age+"\n"+sheepdog.Woof());
    }
}
