package lesson3.util;

import java.util.EmptyStackException;

public class Stack<T> {
    private T[] arr;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack(int capacity) {
        arr = (T[]) new Object[capacity];
        top = -1;
    }

    public Stack() {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public void push(T t) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        arr[++top] = t;
    }

    public boolean isFull() {
        return top + 1 == arr.length;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
