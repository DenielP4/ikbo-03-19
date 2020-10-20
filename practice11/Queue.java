package practice11;

public interface Queue<Q> {
    boolean offer(Q q);
    Q element(); //возвращает элемент из головы очереди, не удаляя его
    Q peek();
    Q remove(); //возвращает элемент из головы очереди и удаляет его
    Q poll();
}
