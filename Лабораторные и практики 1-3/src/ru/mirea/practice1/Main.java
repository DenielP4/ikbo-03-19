package ru.mirea.practice1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Dog dog = new Dog();
        Ball ball = new Ball();
        Book book = new Book();
        dog.setName(in.next());
        dog.setAge(in.nextInt());
        ball.setName(in.next());
        book.setName(in.next());
        book.setAuthor(in.next());
        System.out.println(dog);
        System.out.println(ball);
        System.out.println(book);
    }
}
