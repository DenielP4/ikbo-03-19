package ru.mirea.laba3.dogs;

public abstract class DOG {
    protected String name;
    protected int age;

    public DOG(String name, int age){
        this.name = name;
        this.age = age;
    }
    abstract String Woof();
}
