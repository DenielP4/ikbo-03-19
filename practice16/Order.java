package practice16;

public interface Order {
    boolean add(Item item);
    boolean remove(String itemName);
    boolean remove(Item item);
    int removall(String itemName);
    int removall(Item item);
    int numOfOrders();
    Item[] getArray();
    int costTotal();
    String[]  itemsNames();
    int itemsQuantity();
    int itemsQuantity(String itemName);
    int itemsQuantity(Item item);
    Item[] getItems();
    Object[] sortedItemsByCostDesc();
}
