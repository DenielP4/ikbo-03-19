package practice16;

import java.util.Arrays;
import java.util.Collection;

public class OrderManager implements Order{
    private MyList<Item> data;

    public OrderManager() {
        this.data = new MyList();
    }

    public OrderManager(Collection<Item> collection) {
        this.data = new MyList<>(collection);
    }

    @Override
    public boolean add(Item item) {
        return data.add(item);
    }

    @Override
    public boolean remove(String itemName) {
        Item item = Arrays.stream(
                data.toArray())
                .filter(i -> i.getName().equals(itemName))
                .findFirst()
                .orElse(null);
        if (item == null)
            return false;
        return data.remove(item);
    }

    @Override
    public boolean remove(Item item) {
        return data.remove(item);
    }

    @Override
    public int removall(String itemName) {
        return (int) Arrays.stream(
                data.toArray())
                .filter(i -> i.getName().equals(itemName))
                .map(el -> data.remove(el))
                .count();
    }

    @Override
    public int removall(Item item) {
        return (int) Arrays.stream(
                data.toArray())
                .filter(i -> i.equals(item))
                .map(el -> data.remove(el))
                .count();
    }



    @Override
    public int numOfOrders() {
        return data.getSize();
    }

    @Override
    public Item[] getArray() {
        return data.toArray();
    }
    @Override
    public int costTotal() {
        return (int) Arrays.stream(
                data.toArray())
                .mapToDouble(Item::getPrice)
                .sum();
    }
    @Override
    public  String[] itemsNames() {
        return  data.getNames();
    }

    @Override
    public int itemsQuantity() {
        return 0;
    }
    @Override
    public int itemsQuantity(String itemName) {
        return 0;
    }
    @Override
    public int itemsQuantity(Item item) {
        return 0;
    }
    @Override
    public Item[] getItems() {
        return (Item[]) data.toArray();
    }
    @Override
    public Object[] sortedItemsByCostDesc() {
        return  Arrays.stream(data.toArray()).sorted((o1, o2) -> (int) (o2.getPrice() - o1.getPrice())).toArray();
    }
}
