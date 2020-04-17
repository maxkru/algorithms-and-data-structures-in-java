package lesson6.util;

import java.util.Random;

public class IntegerBinaryTreeGenerator {

    private static Random random = new Random();

    public static BinaryTree<Integer> randomTreeByElementsCount(int nOfElements, int min, int max) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 0; i < nOfElements; i++) {
            tree.add(min + random.nextInt(max - min + 1));
        }
        return tree;
    }

    public static BinaryTree<Integer> randomTreeByLevelCount(int nOfLevels, int min, int max) {
        if (nOfLevels < 0)
            throw new IllegalArgumentException("Number of levels cannot be less than zero");

        BinaryTree<Integer> tree = new BinaryTree<>();
        while(tree.numberOfLevels() < nOfLevels)
            tree.add(min + random.nextInt(max - min + 1));
        return tree;
    }
}
