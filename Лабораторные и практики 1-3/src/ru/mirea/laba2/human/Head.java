package ru.mirea.laba2.human;

public class Head {
    protected String size;
    protected int weight;
    public Head(String size, int weight) {
        this.size = size;
        this.weight = weight;
    }
    public String act() {
        return "Подумала о чем-то философском";
    }
}
