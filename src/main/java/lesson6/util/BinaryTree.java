package lesson6.util;

import java.util.NoSuchElementException;

public class BinaryTree<E extends Comparable<E>> {

    private class Node {
        private Node left;
        private Node right;
        private E element;
        private int size;

        private Node(E element) {
            left = right = null;
            this.element = element;
            size = 1;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E element) {
        return element != null && contains(root, element);
    }

    private boolean contains(Node node, E element) {
        if (node == null)
            return false;

        int cmp = node.element.compareTo(element);
        if (cmp < 0) // node.element < element
            return contains(node.right, element);
        if (cmp > 0) // node.element > element
            return contains(node.left, element);
        return true; // node.element == element
    }

    public void add(E element) {
        if (element == null)
            throw new NullPointerException();

        root = add(root, element);
    }

    private Node add(Node node, E element) {
        if (node == null)
            return new Node(element);

        int cmp = node.element.compareTo(element);
        if (cmp < 0) // node.element < element
            node.right = add(node.right, element);
        if (cmp > 0) // node.element > element
            node.left = add(node.left, element);

        evalSize(node);
        return node;
    }

    public boolean remove(E element) {
        return element != null && remove(root, element) != null;
    }

    private Node remove(Node node, E element) {
        if (node == null)
            return null;

        int cmp = node.element.compareTo(element);
        if (cmp < 0) {
            node.right = remove(node.right, element);
        } else if (cmp > 0) {
            node.left = remove(node.left, element);
        } else {
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            Node min = min(node.right);
            min.right = removeMin(node.right);
            min.left = node.left;
            node = min;
        }

        evalSize(node);
        return node;
    }

    private void evalSize(Node node) {
        node.size = size(node.left) + size(node.right) + 1;
    }

    private Node min(Node node) {
        return node.left == null ? node : min(node.left);
    }

    public E min() {
        if (isEmpty())
            throw new NoSuchElementException("Tree is empty");
        return min(root).element;
    }

    private Node max(Node node) {
        return node.right == null ? node : max(node.right);
    }

    public E max() {
        if (isEmpty())
            throw new NoSuchElementException("Tree is empty");
        return max(root).element;
    }

    private Node removeMin(Node node) {
        if (node.left == null)
            return node.right;

        node.left = removeMin(node.left);
        evalSize(node);
        return node;
    }

}
