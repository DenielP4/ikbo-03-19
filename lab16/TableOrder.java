package lab16;

import java.util.Arrays;
import java.util.Comparator;

public class TableOrder implements Order {
    private int size;
    private MenuItem[] items;
    @Override
    public void add(MenuItem item) {
        if (size > items.length) {
            MenuItem[] t = items.clone();
            items = new MenuItem[size+1];
            System.arraycopy(t, 0, items, 0, t.length);
        }
        items[size] = item;
        size++;
    }
    @Override
    public boolean remove(String itemName) {
        boolean b = false;
        int ind = items.length;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName)) {
                ind = i + 1;
                items[i] = null;
                b = true;
                break;
            }
        }
        for (int i = ind; i < items.length - 1; i++) {
            items[i] = items[i+1];
        }
        items[items.length - 1] = null;
        return b;
    }
    @Override
    public int removeAll(String itemName) {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName)) {
                items[i] = null;
                c++;
            }
        }
        MenuItem[] x = new MenuItem[items.length];
        int ind = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                x[ind] = items[i];
                ind++;
            }
        }
        items = x;
        return c;
    }
    @Override
    public int itemsQuantity() {
        return size;
    }
    @Override
    public int itemQuantity(String itemName) {
        int c = 0;
        for (MenuItem item : items) {
            if (item.getName().equals(itemName)) c++;
        }
        return c;
    }
    @Override
    public MenuItem[] getItems() {
        return items;
    }
    @Override
    public int costTotal() {
        int k = 0;
        for (MenuItem item : items) {
            k += item.getPrice();
        }
        return k;
    }
    @Override
    public MenuItem[] sortedItemsByCostDesc() {
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
