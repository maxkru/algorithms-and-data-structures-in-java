package lesson4.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> { // doubly-linked list

    private class LLIterator implements Iterator<T> {

        private Node node;
        private boolean removePermitted;

        LLIterator() {
            node = new Node(null);
            node.next = first;
            removePermitted = false;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = node.next.item;
            node = node.next;
            removePermitted = true;
            return item;
        }

        @Override
        public void remove() {
            if (node == null || !removePermitted) {
                throw new IllegalStateException();
            }
            removeNode(node);
            removePermitted = false;
            size--;
        }
    }

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
                removeNode(node);
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

    public Iterator<T> iterator() {
        return new LLIterator();
    }

    private void removeNode(Node node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        } else { // we are deleting last
            last = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else { // we are deleting first
            first = node.next;
        }
    }
}
