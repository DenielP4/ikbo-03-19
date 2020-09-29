package practice8;

/**
 *
 */
public class UnfairWaitList<E> extends WaitList<E> {
    /**
     *
     */
    public UnfairWaitList() {
        super();
    }

    /**
     * @return
     */

    public void remove(E element) {
        this.remove(element);
    }
    public void moveToBack(E element){
        super.add(element);
    }
}

