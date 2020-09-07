package ru.mirea.laba3.dogs;

public class Labrador extends DOG{
    public Labrador(String name, int age) {
        super(name, age);
    }
    @Override
    String Woof() {
        return "ГАВ-ГАВ";
    }
}
