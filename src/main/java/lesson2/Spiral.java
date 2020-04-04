package lesson2;

import java.util.Arrays;

public class Spiral {

    public static void main(String[] args) {
        int[][] a = makeSpiral(5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(a));
    }

    public static int[][] makeSpiral(int n) {
        int[][] result = new int[n][n];
        int curr = 1;
        int nOfCycles = n / 2 + n % 2;
        for (int i = 0; i < nOfCycles; i++) {
            // верхняя сторона квадрата
            for (int j = i; j < n - i; j++) {
                result[i][j] = curr++;
            }
            // правая сторона квадрата
            for (int j = i + 1; j < n - i; j++) {
                result[j][n - i - 1] = curr++;
            }
            // нижняя сторона квадрата
            for (int j = n - i - 2; j >= i; j--) {
                result[n - i - 1][j] = curr++;
            }
            // левая сторона квадрата
            for (int j = n - i - 2; j > i; j--) {
                result[j][i] = curr++;
            }
        }
        return result;
    }
}
