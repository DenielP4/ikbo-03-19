package practice11;

import java.util.NoSuchElementException;

public abstract class AbstractQueue<Q> implements Queue<Q> {
    public AbstractQueue() {}

    public void all_remove() {
        while (peek() != null);
    }

    @Override
    public Q element() {
        Q a = peek();
        if (a != null) {
            return a;
        }
        throw new NoSuchElementException();
    }

    @Override
    public Q remove() {
        Q a = poll();
        if (a != null) {
            return a;
        }
        throw new NoSuchElementException();
    }
}