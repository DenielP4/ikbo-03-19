package ru.mirea.laba2.human;

public class Lag {
    protected String size;
    protected int weight;
    public Lag(String size, int weight) {
        this.size = size;
        this.weight = weight;
    }
    public String act() {
        return "Пнула мяч";
    }
}
