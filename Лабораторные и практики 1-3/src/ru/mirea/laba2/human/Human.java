package ru.mirea.laba2.human;

import java.util.Scanner;

public class Human {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Head head = new Head(in.next(), in.nextInt());
        Hand hand = new Hand(in.next(), in.nextInt());
        Lag lag = new Lag(in.next(), in.nextInt());
        System.out.println("Параметры человека:\n\tГолова:\n\t\tРазмер: "+head.size+"\n\t\tВес: "+head.weight);
        System.out.println("\n\tРука:\n\t\tРазмер: "+hand.size+"\n\t\tВес: "+hand.weight);
        System.out.println("\n\tНога:\n\t\tРазмер: "+lag.size+"\n\t\tВес: "+lag.weight);
    }
}
