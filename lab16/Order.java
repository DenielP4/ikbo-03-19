package lab16;

public interface Order {
    void add(MenuItem item);
    int itemsQuantity();
    int itemQuantity(String itemName);
    MenuItem[] getItems();
    boolean remove(String itemName);
    int removeAll(String itemName);
    MenuItem[] sortedItemsByCostDesc();
    int costTotal();
}
