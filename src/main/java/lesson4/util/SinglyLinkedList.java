package lesson4.util;

public class SinglyLinkedList<T> {

    private class Node {
        private Node next;
        private T item;

        private Node(T item) {
            this.item = item;
        }
    }

    private int size;
    private Node first;

    public SinglyLinkedList() {
        first = null;
        size = 0;
    }

    public void add(T item) {
        Node newFirst = new Node(item);
        newFirst.next = first;
        first = newFirst;
        size++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T remove() {
        if (isEmpty())
            throw new IllegalStateException();
        T result = first.item;
        first = first.next;
        return result;
    }

    public boolean contains(T item) {
        Node node = first;
        while (node != null) {
            if (item.equals(node.item)) {
                return true;
            }
            node = node.next;
        }
        return false;
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
