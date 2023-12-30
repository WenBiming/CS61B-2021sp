package deque;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int front;
    private int end;

    public int getIdx(int i) {
        int capacity = items.length;
        return (i % capacity + capacity) % capacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return items.length;
    }
    public ArrayDeque() {
        items = (T[]) new Object[16];
        size = 0;
        front = 1;
        end = 0;
    }

    @Override
    public void addFirst(T item) {
        front = getIdx(front - 1);
        items[front] = item;
        size += 1;

        if (size == items.length)
            expand();
    }

    @Override
    public void addLast(T item) {
        end = getIdx(end + 1);
        items[end] = item;
        size += 1;

        if (size == items.length)
            expand();
    }


    @Override
    public T removeFirst() {
        if (isEmpty())
            return null;

        T val = items[front];
        items[front] = null;
        front = getIdx(front + 1);
        size -= 1;

        if (size > 0 && items.length >= 16 && 1.0 * size / items.length < 0.25)
            contract();
        return val;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            return null;

        T val = items[end];
        items[end] = null;
        end = getIdx(end - 1);
        size -= 1;

        if (size > 0 && items.length > 16 && 1.0 * size / items.length < 0.25)
            contract();
        return val;
    }

    public void contract() {
        T[] newArr = (T[]) new Object[items.length / 2];
        for (int i = 0; i < size; i ++) {
            int idx = getIdx(front + i);
            newArr[i] = items[idx];
        }

        front = 0;
        end = front + size - 1;
        items = newArr;
    }
    public void expand() {
        T[] newArr = (T[]) new Object[items.length * 2];
        for (int i = 0; i < size; i ++) {
            int idx = getIdx(front + i);
            newArr[i] = items[idx];
        }
        front = 0;
        end = front + size - 1;
        items = newArr;
    }

    @Override
    public T get(int index) {
       int idx = getIdx(index + front);
       return items[idx];
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size(); i ++)
            System.out.println(get(i) + " ");
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayDeque))
            return false;

        if (size != ((ArrayDeque<?>) o).size)
            return false;

        for (int i = 0; i < size; i ++)
            if (!(((ArrayDeque<?>) o).get(i).equals(this.get(i))))
                return false;

        return true;

    }
}
