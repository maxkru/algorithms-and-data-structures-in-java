package lesson6;

import lesson6.util.BinaryTree;
import lesson6.util.IntegerBinaryTreeGenerator;

public class Main {

    private static final int NUMBER_OF_TREES = 20;

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_TREES; i++) {
            BinaryTree<Integer> tree = IntegerBinaryTreeGenerator.randomTreeByLevelCount(6, -100, 100);
        }

    }

}
