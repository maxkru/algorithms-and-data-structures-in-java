package lesson4.util;

import java.util.NoSuchElementException;

public class LinkedList<T> { // doubly-linked list

    private class Node {
        private Node prev;
        private Node next;
        private T item;

        private Node(T item) {
            this.item = item;
        }

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    public LinkedList() {
        first = last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T peekFirst() {
        return first == null ? null : first.item;
    }

    public T peekLast() {
        return last == null ? null : last.item;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (isEmpty())
            last = newNode;
        else
            first.prev = newNode;
        newNode.next = first;
        first = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty())
            first = newNode;
        else
            last.next = newNode;
        newNode.prev = last;
        last = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        T item = first.item;
        first = first.next;
        if (first == null)
            last = null;
        else
            first.prev = null;
        return item;
    }

    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        T item = last.item;
        last = last.prev;
        if (last == null)
            first = null;
        else
            last.next = null;
        return item;
    }

    public int indexOf(T item) {
        Node node = first;
        int index = 0;
        while(node != null) {
            if (item.equals(node.item))
                return index;
            node = node.next;
            index++;
        }
        return -1;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Node node = first;
        for (int i = 0; i < index; i++)
            node = node.next;
        Node newNode = new Node(item);
        node.prev.next = newNode;
        node.prev = newNode;
        newNode.next = node;
        size++;
    }

    public boolean remove(T item) {
        Node node = first;
        while(node != null) {
            if (item.equals(node.item)) {
                node.next.prev = node.prev;
                node.prev.next = node.next;
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        Node node = first;
        while (node != null) {
            sb.append(node.item.toString()).append(", ");
            node = node.next;
        }

        if (sb.length() > "[".length()) {
            sb.setLength(sb.length() - ", ".length());
        }

        sb.append("]");

        return sb.toString();
    }
}
