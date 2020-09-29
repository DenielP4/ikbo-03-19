package practice8;

import java.util.Collection;

/**
 * @param <E>
 */
public interface IWaitList<E> {
    /**
     * @param element
     */
    void add(E element);

    /**
     * @return
     * @param
     */
    E remove();

    /**
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * @param contentCheck
     * @return
     */
    boolean containsAll(Collection<E> contentCheck);


    /**
     * @return
     */
    boolean isEmpty();
}
