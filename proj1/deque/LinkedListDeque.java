package deque;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> implements Deque<T>{
    private  class Node {
        private T value;
        private Node next;
        private Node prev;
        Node(T v, Node n, Node p) {
            this.value = v;
            this.next = n;
            this.prev = p;
        }

        Node(T v) {
            this.value = v;
            this.next = null;
            this.prev = null;
        }

        Node() {
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
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
    }



    @Override
    public void addFirst(T item) {
        Node node = new Node(item);
        sentinel.next.prev = node;
        node.next = sentinel.next;
        node.prev = sentinel;
        sentinel.next = node;

        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node node = new Node(item);
        sentinel.prev.next = node;
        node.next = sentinel;
        node.prev = sentinel.prev;
        sentinel.prev = node;

        size += 1;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node node = sentinel.next;
        T val = node.value;
        sentinel.next = node.next;
        node.next.prev = sentinel;

        size -= 1;
        return val;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

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

    @Override
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

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }

        int n = index;
        Node tmp = sentinel.next;
        while (n != 0) {
            tmp = tmp.next;
            n -= 1;
        }
        return tmp.value;

    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }

        return getFromNode(sentinel.next, index);

    }

    private T getFromNode(Node n, int index) {
        assert n != null;

        if (index == 0) {
            return n.value;
        }

        return getFromNode(n.next, index - 1);
    }

    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }


        o = (LinkedListDeque<T>)o;
        if (size != ((LinkedListDeque<?>) o).size) {
            return false;
        }


        for (int i = 0; i < size; i++)
            if (!(((LinkedListDeque<?>) o).get(i).equals(this.get(i)))) {
                return false;
            }


        return true;

    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node currNode = sentinel.next;
            @Override
            public boolean hasNext() {
                return currNode != sentinel;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T res = currNode.value;
                currNode = currNode.next;
                return res;
            }
        };
    }

}
