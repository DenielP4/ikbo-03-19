package com.company;

public class Mouse implements Priceable{
    private int price;
    public Mouse(int price) {
        this.price = price;
    }
    @Override
    public int getPrice() {
        return price;
    }
}
