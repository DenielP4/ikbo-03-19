package lab16;

import java.util.Arrays;
import java.util.Comparator;

public class InternetOrder implements Order {
    private int size;
    private ListNode head;
    private ListNode tail;
    @Override
    public void add(MenuItem item) {
        if (head != null) {
            ListNode t = new ListNode();
            t.value = item;
            t.next = tail;
            head.next = t;
        } else {
            head = new ListNode();
            tail = new ListNode();
            head.value = item;
            head.next = tail;
            tail.next = head;
        }
        size++;
    }
    @Override
    public boolean remove(String itemName) {
        ListNode t = tail;
        do {
            if (t.next.value.getName().equals(itemName)) {
                t.next = t.next.next;
                size--;
                return true;
            }
            t = t.next;
        } while (t != tail);
        return false;
    }
    @Override
    public int removeAll(String itemName) {
        int c = 0;
        ListNode t = tail;
        do {
            if (t.next.value.getName().equals(itemName)) {
                t.next = t.next.next;
                c++;
            }
            t = t.next;
        } while (t != tail);
        return c;
    }
    @Override
    public int itemsQuantity() {
        return size;
    }
    @Override
    public int itemQuantity(String itemName) {
        int c = 0;
        ListNode t = tail;
        do {
            if (t.value.getName().equals(itemName)) c++;
            t = t.next;
        } while (t != tail);
        return c;
    }
    @Override
    public MenuItem[] getItems() {
        MenuItem[] items = new MenuItem[size];
        ListNode t = tail;
        int i = 0;
        do {
            items[i] = t.value;
            i++;
            t = t.next;
        } while (t != tail);
        return items;
    }
    @Override
    public int costTotal() {
        MenuItem[] items = getItems();
        int k = 0;
        for (MenuItem item: items) {
            k += item.getPrice();
        }
        return k;
    }
    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] items = getItems();
        Arrays.sort(items, new Comparator<MenuItem>() {
            @Override
            public int compare(MenuItem i1, MenuItem i2) {
                double razn = i2.getPrice() - i1.getPrice();
                return (int)razn;
            }
        });
        return items;
    }
}
