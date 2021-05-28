/**
 * @file: LinkedListDeque.java
 * @time: 2021/5/28 11:01 AM
 * @Author by Pking
 * <p>
 * by circular LinkedList to achieve Deque
 */
public class LinkedListDeque<Item> {

//    public static void main(String[] args) {
//        LinkedListDeque t = new LinkedListDeque();
//        System.out.println(t.isEmpty());
//        t.addFirst(1);
//        t.addFirst(2);
//        t.addLast(10);
//        t.addLast(100);
//        t.addLast(11);
//        t.addLast(101);
//        t.addLast(12);
//        t.addLast(102);
//        System.out.println(t.isEmpty());
//        System.out.println(t.size());
//        t.printDeque();
//        System.out.println("first= " + t.removeFirst());
//        t.printDeque();
//        System.out.println("last= " + t.removeLast());
//        t.printDeque();
//        System.out.println(t.get(10));
//
//        System.out.println(t.getRecursive(2));
//
//    }

    public class IntNode {
        public Item item;
        public IntNode pre;
        public IntNode next;

        public IntNode(Item i, IntNode n, IntNode p) {
            this.item = i;
            this.next = n;
            this.pre = p;
        }
    }

    public int size;
    public IntNode sentinel;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;  //produce a null cirluar LL
    }

    public void addFirst(Item item) {
        sentinel.next.pre = new IntNode(item, sentinel.next, sentinel);
        sentinel.next = sentinel.next.pre;
        size += 1;
    }

    public void addLast(Item item) {
        sentinel.pre.next = new IntNode(item, sentinel, sentinel.pre);
        sentinel.pre = sentinel.pre.next;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Item removeFirst() {
        if(sentinel.next == sentinel){
            return null;
        }
        IntNode first = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.pre = sentinel;
        size -= 1;
        return first.item;
    }

    public Item removeLast() {
        if(sentinel.next == sentinel){
            return null;
        }
        IntNode last = sentinel.pre;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.pre.next = sentinel;
        size -= 1;
        return last.item;
    }

    public Item get(int index){
        IntNode ptr = sentinel;
        int i = 0;
        while(ptr.next != sentinel){
            if(i == index){
                return ptr.next.item;
            }
            i++;
            ptr = ptr.next;
        }
        return null;
    }

    public Item getRecursiveHelper(IntNode a, int i) {
        if(i == 0) {
            return a.next.item; //exit
        }else{
            a = a.next;
            i -= 1;
        }
        return getRecursiveHelper(a, i);
    }

    public Item getRecursive(int index) {
        if(index > (size - 1)){
            return null;
        }
        IntNode p = sentinel;
        return getRecursiveHelper(p, index);
    }
}
