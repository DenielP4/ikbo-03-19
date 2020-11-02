package lab16;

public class InternetOrderManager implements OrderManager {
    private int size;
    private QueueNode head = null;
    private QueueNode tail = null;
    public void add(Order order) {
        if (head != null) {
            QueueNode t = new QueueNode();
            t.value = order;
            t.next = tail;
            head.next = t;
        } else {
            head = new QueueNode();
            tail = new QueueNode();
            head.value = order;
            head.next = tail;
            tail.next = head;
        }
        size++;
    }
    @Override
    public int itemsQuantity(String itemName) {
        int c = 0;
        QueueNode t = tail;
        do {
            c += t.value.itemQuantity(itemName);
            t = t.next;
        }
        while (t != tail);
        return c;
    }
    @Override
    public int itemsQuantity(MenuItem item) {
        return itemsQuantity(item.getName());
    }
    @Override
    public Order[] getOrders() {
        Order[] orders = new Order[size];
        int i = 0;
        QueueNode t = tail;
        do {
            orders[i] = t.value;
            i++;
            t = t.next;
        }
        while (t != tail);
        return orders;
    }
    @Override
    public int ordersCostSummary() {
        Order[] orders = getOrders();
        int s = 0;
        for (Order order: orders) {
            s += order.costTotal();
        }
        return s;
    }
    @Override
    public int ordersQuantity() {
        return size;
    }
}
