package deque;


public class LinkedListDeque<T> {
    private  class Node {
        public T value;
        public Node next;
        public Node prev;
        public Node(T v, Node n, Node p) {
            this.value = v;
            this.next = n;
            this.prev = p;
        }

        public Node(T v) {
            this.value = v;
            this.next = null;
            this.prev = null;
        }

        public Node() {
            this.value = null;
            this.next = null;
            this.prev = null;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        this.size = 0;
        this.sentinel = new Node();
        this.sentinel.next= this.sentinel;
        this.sentinel.prev = this.sentinel;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    /*
    Invariants:
    1. If not empty, the first node is always the next of Sentinel
    2. If not empty, the last node is always the prev of Sentinel
     */
    public void addFirst(T item) {
        Node node = new Node(item);
        sentinel.next.prev = node;
        node.next = sentinel.next;
        node.prev = sentinel;
        sentinel.next = node;

        size += 1;
    }

    public void addLast(T item) {
        Node node = new Node(item);
        sentinel.prev.next = node;
        node.next = sentinel;
        node.prev = sentinel.prev;
        sentinel.prev = node;

        size += 1;
    }

    public T removeFirst() {
        if (isEmpty())
            return null;
        Node node = sentinel.next;
        T val = node.value;
        sentinel.next = node.next;
        node.next.prev = sentinel;

        size -= 1;
        return val;
    }

    public T removeLast() {
        if (isEmpty())
            return null;
        Node node = sentinel.prev;
        T val = node.value;
        node.prev.next = sentinel;
        sentinel.prev = node.prev;

        size -= 1;
        return val;
    }
    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println();
            return;
        }

        Node tmp = sentinel.next;
        while (tmp != sentinel) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public T get(int index) {
        if (index >= size)
            return null;
        int n = index;
        Node tmp = sentinel.next;
        while (n != 0) {
            tmp = tmp.next;
            n -= 1;
        }
        return tmp.value;

    }

    public T getRecursive(int index) {
        if (index >= size)
            return null;
        return getFromNode(sentinel.next, index);

    }

    private T getFromNode(Node n, int index) {
        assert n != null;

        if (index == 0)
            return n.value;
        return getFromNode(n.next, index - 1);
    }

    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque))
            return false;

        o = (LinkedListDeque<T>)o;
        if (size != ((LinkedListDeque<?>) o).size)
            return false;

        for (int i = 0; i < size; i ++)
            if (!(((LinkedListDeque<?>) o).get(i).equals(this.get(i))))
                return false;

        return true;

    }

}
