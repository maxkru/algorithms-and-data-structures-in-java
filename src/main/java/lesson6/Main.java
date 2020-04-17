package lesson6;

import lesson6.util.BinaryTree;
import lesson6.util.IntegerBinaryTreeGenerator;

public class Main {

    private static final int NUMBER_OF_TREES = 200000;

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < NUMBER_OF_TREES; i++) {
            BinaryTree<Integer> tree = IntegerBinaryTreeGenerator.randomTreeByLevelCount(6, -100, 100);
            System.out.println("Tree " + (i + 1));
            int left = tree.rootLeftBranchSize();
            int right = tree.rootRightBranchSize();
            int diff = Math.abs(left - right);
            boolean imbalanced = (diff >= left) || (diff >= right);
            if (imbalanced)
                count++;
            System.out.printf("Left = %d, right = %d, diff = %d, %s\n\n", left, right, diff, imbalanced ? "NOT balanced" : "balanced");
        }
        System.out.printf("Out of %d trees, %d (%.1f%%) were counted as imbalanced.", NUMBER_OF_TREES, count, ((float) count * 100) / NUMBER_OF_TREES);
        // Out of 200000 trees, 149834 (74.9%) were counted as imbalanced.
    }

}
