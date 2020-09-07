package ru.mirea.laba2.circle;
import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle circle=new Circle(sc.nextDouble());
        System.out.println(circle.rad+" "+circle.area+" "+circle.pir);
        circle.resetRad(sc.nextDouble());
        System.out.println(circle.rad+" "+circle.area+" "+circle.pir);
    }
}
