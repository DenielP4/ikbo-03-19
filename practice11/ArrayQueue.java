package practice11;

import java.util.ArrayList;

public class ArrayQueue<Q> extends AbstractQueue<Q> {
    private ArrayList<Q> x;

    public ArrayQueue() {
        this.x = new ArrayList<>();
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
            x.remove(0);
            return x.get(0);
        }
        return null;
    }

    @Override
    public String toString() {
        return x.toString();
    }
}
