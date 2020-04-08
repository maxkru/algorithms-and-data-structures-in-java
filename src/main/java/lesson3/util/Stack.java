package lesson3.util;

import java.util.EmptyStackException;

public class Stack<T> {
    private T[] arr;
    private int pointer;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack(int capacity) {
        arr = (T[]) new Object[capacity];
        pointer = -1;
    }

    public Stack() {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
        pointer = -1;
    }

    public void push(T t) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        arr[++pointer] = t;
    }

    public boolean isFull() {
        return pointer + 1 == arr.length;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[pointer--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[pointer];
    }

    public boolean isEmpty() {
        return pointer == -1;
    }
}
