package lesson3.util;

public class PriorityQueue<T extends Comparable<T>> extends Queue<T> {

    public PriorityQueue(int capacity) {
        arr = (T[]) new Comparable[capacity];
        back = front = size = 0;
    }

    public PriorityQueue() {
        arr = (T[]) new Comparable[DEFAULT_CAPACITY];
        back = front = size = 0;
    }

    @Override
    public void add(T t) {
        if (size == arr.length)
            throw new IllegalStateException("Queue overflow");
        arr[front] = t;
        size++;
        int i = front;
        while (i != back && arr[i].compareTo(arr[nextLeftIndex(i)]) < 0) {
            swap(i, nextLeftIndex(i));
            i = nextLeftIndex(i);
        }
        front = (front + 1) % arr.length;
    }

    private void swap(int i1, int i2) {
        T t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }

}
