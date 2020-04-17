package lesson6;

import lesson6.util.BinaryTree;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(1);
        tree.add(-10);
        tree.add(10);
        tree.add(2);

        System.out.println(tree.remove(2));
        System.out.println(tree.contains(2));
    }

}
