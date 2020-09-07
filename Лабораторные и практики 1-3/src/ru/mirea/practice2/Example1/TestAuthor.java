package ru.mirea.practice2.Example1;

import java.util.Scanner;

public class TestAuthor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Author author = new Author("Lev Tolstoy", "levtolstoy@yandex.ru", 'M');
        System.out.println(author);
    }
}
