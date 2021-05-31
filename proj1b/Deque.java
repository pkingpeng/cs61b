/**
 * @file: Deque.java
 * @time: 2021/5/30 3:54 PM
 * @Author by Pking
 */
public interface Deque<Item> {
    /** The duque API methods */
    void addFirst(Item item);

    void addLast(Item item);

    boolean isEmpty();

    int size();

    void printDeque();

    Item removeFirst();

    Item removeLast();

    Item get(int index);
}
