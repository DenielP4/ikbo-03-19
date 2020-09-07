package ru.mirea.laba2.human;

public class Hand {
    protected String size;
    protected int weight;
    public Hand(String size, int weight) {
        this.size = size;
        this.weight = weight;
    }
    public String act() {
        return "Взяла яблоко";
    }
}
