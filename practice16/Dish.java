package practice16;

final class Dish implements Item {
    final private int price;
    final private String name;
    final private String description;

    public Dish(String name, String description) {
        this.name = name;
        this.description = description;
        this.price = 0;
    }

    public Dish(int price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Dish {" +
                "price = " + price +
                ", name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                '}';
    }
}
