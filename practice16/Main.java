package practice16;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Item dish01 = new Dish(1500, "Lasagne", "Type of wide, flat pasta");
        Item dish02 = new Dish(2050, "Veal Orloff", "Dish of Russian cuisine");
        Item drink01 = new Drink(50, "Peach juice", "Tasty juice");
        Item drink02 = new Drink(100, "Black coffee", "Very bitter, dark coffee");

        Order order01 = new RestaurantOrder();
        order01.add(dish01);
        order01.add(drink01);
        System.out.println("order01:");
        System.out.println(Arrays.toString(order01.sortedItemsByCostDesc()));

        Order order02 = new InternetOrder();
        order02.add(dish02);
        order02.add(drink02);
        System.out.println("order02:");
        System.out.println(Arrays.toString(order02.sortedItemsByCostDesc()));

        InternetOrder order03 = new InternetOrder();
        order03.add("Moscow", order02);
        order03.add("Moscow", drink01);
        System.out.println("order03:");
        order03.getOrders();

        System.out.println(Arrays.toString(order01.getItems()));

        order01.add(dish02);
        System.out.println("add item to order01:");
        System.out.println(Arrays.toString(order01.getItems()));
        System.out.println("Num of orders in order01: " + order01.numOfOrders());
        System.out.println("Total sum in order01: " + order01.costTotal());
        order01.remove("Lasagne");
        System.out.println(Arrays.toString(order01.itemsNames()));
        order01.add(drink01);
        order01.add(drink01);

        System.out.println(Arrays.toString(order01.itemsNames()));
        System.out.println("deleted: " + order01.removall("Peach juice"));
        System.out.println(Arrays.toString(order01.itemsNames()));
    }
}
