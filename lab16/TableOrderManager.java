package lab16;

import java.util.ArrayList;

public class TableOrderManager implements OrderManager{
    private Order[] orders;
    public void add(Order order, int tableNumber) {
        orders[tableNumber] = order;
    }
    public void addItem(MenuItem item, int tableNumber) {
        orders[tableNumber].add(item);
    }
    public int freeTableNumber() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) return i;
        }
        return -1;
    }
    public int[] freeTableNumbers() {
        ArrayList<Integer> ln = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) ln.add(i);
        }
        int[] numbers = new int[ln.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ln.get(i);
        }
        return numbers;
    }
    public Order getOrder(int tableNumber) {
        return orders[tableNumber];
    }
    public void remove(int tableNumber) {
        orders[tableNumber] = null;
    }
    public int remove(Order order) {
        for (int i = 0; i < orders.length; i++) {
            if (order == orders[i]) {
                orders[i] = null;
                return i;
            }
        }
        return -1;
    }
    public int removeAll(Order order) {
        int c = 0;
        for (int i = 0; i < orders.length; i++) {
            if (order == orders[i]) {
                orders[i] = null;
                c++;
            }
        }
        return c;
    }
    @Override
    public int itemsQuantity(String itemName) {
        int c = 0;
        for (Order order: orders) {
            c += order.itemQuantity(itemName);
        }
        return c;
    }
    @Override
    public int itemsQuantity(MenuItem item) {
        return itemsQuantity(item.getName());
    }
    @Override
    public Order[] getOrders() {
        return orders;
    }
    @Override
    public int ordersCostSummary() {
        int s = 0;
        for (Order order: orders) {
            s += order.costTotal();
        }
        return s;
    }
    @Override
    public int ordersQuantity() {
        return orders.length;
    }
}
