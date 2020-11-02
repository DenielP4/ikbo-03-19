package practice16;

import java.util.Collection;

public class MyList<T> {
    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public MyList() {}

    public MyList(Collection<? extends T> collection) {
        addAll(collection);
    }

    public boolean add(T element) {
        linkLast(element);
        return true;
    }

    public boolean addAll(Collection<? extends T> collection) {
        return addAll(size, collection);
    }

    @SuppressWarnings("unchecked")
    public boolean addAll(int index, Collection<? extends T> collection) {
        checkIndex(index);
        Object[] objects = collection.toArray();
        int numNew = objects.length;
        if (numNew == 0)
            return false;
        Node<T> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }
        for (Object obj : objects) {
            T e = (T) obj;
            Node<T> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }
        if (succ == null)
            last = pred;
        else {
            pred.next = succ;
            succ.prev = pred;
        }
        size += numNew;
        return true;
    }

    public boolean remove(Object object) {
        if (object == null) {
            for (Node<T> f = first; f != null; f = f.next) {
                if (f.element == null) {
                    unlink(f);
                    return true;
                }
            }
        } else {
            for (Node<T> f = first; f != null; f = f.next) {
                if (object.equals(f.element)) {
                    unlink(f);
                    return true;
                }
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    private void checkIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException();
    }



    private void linkLast(T element) {
        Node<T> last = this.last;
        Node<T> newNode = new Node<>(last, element, null);
        this.last = newNode;
        if (last == null)
            first = newNode;
        else
            last.next = newNode;
        size++;
    }

    private void unlink(Node<T> el) {
        Node<T> next = el.next;
        Node<T> prev = el.prev;
        if (prev == null)
            first = next;
        else {
            prev.next = next;
            el.prev = null;
        }
        if (next == null)
            last = prev;
        else {
            next.prev = prev;
            el.next = null;
        }
        el.element = null;
        size--;
    }

    private Node<T> node(int index) {
        Node<T> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
        } else {
            node = last;
            for (int i = size - 1; i > index; i--)
                node = node.prev;
        }
        return node;
    }
    public String[] getNames (){
        String[] result = new String[size];
        int i = 0;
        for (Node<Item> x = (Node<Item>) first; x != null; x = x.next)
            result[i++] = x.element.getName();
        return  result;
    }
    @SuppressWarnings("unchecked")
    public Item[] toArray() {
        Item[] result = new Item[size];
        int i = 0;
        for (Node<T> x = first; x != null; x = x.next)
            result[i++] = (Item) x.element;
        return  result;
    }
}