package lesson3.util;

import java.util.NoSuchElementException;

public class Deque<T> extends Queue<T> {

    public void addLast(T t) {
        add(t);
    }

    public T removeFirst() {
        return remove();
    }

    public T getFirst() {
        return element();
    }

    public void addFirst(T t) {
        if (size == arr.length)
            throw new IllegalStateException("Queue overflow");
        back = nextLeftIndex(back);
        arr[back] = t;
        size++;
    }

    public T removeLast() {
        if (size == 0)
            throw new NoSuchElementException();
        front = nextLeftIndex(front);
        T result = arr[front];
        arr[front] = null;
        size--;
        return result;
    }

    public T getLast() {
        if (size == 0)
            throw new NoSuchElementException();
        return arr[nextLeftIndex(front)];
    }

    private int nextLeftIndex(int i) {
        return i == 0 ? arr.length - 1 : i - 1;
    }
}
