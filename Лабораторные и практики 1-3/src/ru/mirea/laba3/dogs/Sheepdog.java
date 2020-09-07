package ru.mirea.laba3.dogs;

public class Sheepdog extends DOG {
    public Sheepdog(String name, int age) {
        super(name, age);
    }
    @Override
    String Woof() {
        return "Вуф-вуф";
    }
}
