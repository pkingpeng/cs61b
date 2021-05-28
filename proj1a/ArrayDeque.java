/**
 * @file: ArrayDeque.java
 * @time: 2021/5/28 6:02 PM
 * @Author by Pking
 */
public class ArrayDeque<Item> {
//    public static void main(String[] args) {
//        ArrayDeque arr = new ArrayDeque();
//        for(int i = 0; i < 10; i++){
//            arr.addFirst((int) i);
//        }
//        arr.printDeque();
//        arr.addLast((int) 11);
//        arr.addLast((int) 12);
//        arr.printDeque();
//        arr.removeFirst();
//        arr.removeFirst();
//        arr.printDeque();
//        arr.removeLast();
//        arr.removeLast();
//        arr.printDeque();
//        System.out.println(arr.get(100));
//        System.out.println(arr.get(4));
//
//    }

    public ArrayDeque(){
        this.items = (Item[])new Object[8];
    }



    Item[] items;
    int size = 0;
    final int RFACTOR = 4;

    public void resize(int capacity) {
        Item[] a = (Item[])new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(Item item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        Item[] a = (Item[])new Object[size + 1];
        System.arraycopy(items, 0, a, 1, size);
        items = a;
        items[0] = item;
        size += 1;
    }

    public void addLast(Item item) {
        if (size == items.length) {
            resize(items.length * RFACTOR);
        }
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque() {
        for(int i =0; i < size; i++){
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public Item removeLast(){
        if(size == 0){
            return null;
        }
        Item x = items[size - 1];
        items[size - 1] = null; // null
        size -= 1;

        //ratio < 0.25 resize;
        if(size * 4 < items.length){
            resize(items.length / RFACTOR);
        }
        return x;
    }

    public Item removeFirst() {
        if(size == 0){
            return null;
        }

        Item x = items[0];
        Item[] a = (Item[])new Object[size];
        System.arraycopy(items, 1, a, 0, size - 1);
        items = a;
        size -= 1;

        //ratio < 0.25 resize;
        if(size * 4 < items.length){
            resize(items.length / RFACTOR);
        }

        return x;
    }

    public Item get(int index){
        if(index >= size){
            return null; //null
        }
        return items[index];
    }
}
