package lesson3.util;

import java.util.NoSuchElementException;

public class Queue<T> {

    protected static final int DEFAULT_CAPACITY = 10;

    protected T[] arr;
    protected int back, front;
    protected int size;

    public Queue(int capacity) {
        arr = (T[]) new Object[capacity];
        back = front = size = 0;
    }

    public Queue() {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
        back = front = size = 0;
    }

    public void add(T t) {
        if (size == arr.length)
            throw new IllegalStateException("Queue overflow");
        arr[front] = t;
        front = (front + 1) % arr.length;
        size++;
    }

    public T remove() {
        if (size == 0)
            throw new NoSuchElementException();
        T result = arr[back];
        arr[back] = null;
        back = nextIndex(back);
        size--;
        return result;
    }

    public T element() {
        if (size == 0)
            throw new NoSuchElementException();
        return arr[back];
    }

    private int nextIndex(int i) {
        return (i + 1) % arr.length;
    }

    public int size() {
        return size;
    }
}
