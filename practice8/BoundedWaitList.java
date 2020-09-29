package practice8;

/**
 *
 */
public class BoundedWaitList<E> extends WaitList<E> {
    private int capacity;

    /**
     * @param capacity
     */
    public BoundedWaitList(int capacity) {
        super();
        this.capacity = capacity;
    }

    /**
     * @param element
     */
    @Override
    public void add(E element) {
        super.add(element);

    }


    /**
     * @return
     */
    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                ", content=" + content +
                '}';
    }

    /**
     * @return
     */
    public int getCapacity() {
        return capacity;
    }
}
