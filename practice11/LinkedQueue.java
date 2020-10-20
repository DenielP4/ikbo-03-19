package practice11;

import java.util.LinkedList;

public class LinkedQueue<Q> extends AbstractQueue<Q> {
    private LinkedList<Q> x;

    public LinkedQueue() {
        this.x = new LinkedList<>();
    }

    @Override
    public boolean offer(Q q) {
        return x.add(q);
    }

    @Override
    public Q peek() {
        if (!x.isEmpty()) return x.get(0);
        else return null;
    }

    @Override
    public Q poll() {
        if (!x.isEmpty()) {
            return x.pollFirst();
        }
        return null;
    }

    @Override
    public String toString() {
        return x.toString();
    }
}
