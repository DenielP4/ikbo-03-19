package com.company;

public class Main {

    public static void main(String[] args) {
        Priceable pen = new Pen(100);
        Priceable phone = new Pen(15000);
        Priceable mouse = new Pen(95000);
        System.out.println(pen.getPrice());
        System.out.println(phone.getPrice());
        System.out.println(mouse.getPrice());
    }
}
