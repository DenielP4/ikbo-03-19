package practice16;

final public class Drink implements Item {
    final private double price;
    final private String name;
    final private String description;

    public Drink(String name, String description) {
        this.name = name;
        this.description = description;
        this.price = 0;
    }

    public Drink(double price, String name, String description) {
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
        return "Drink {" +
                "price = " + price +
                ", name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                '}';
    }
}
