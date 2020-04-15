package lesson5.util;

import java.util.Random;

public class Math {

    public static long pow(long a, int b) {
        if (b == 1)
            return a;
        if (b % 2 == 0)
            return pow(a * a, b / 2);
        return a * pow(a, b - 1);
    }

    public static int[] generateRandomArray(int length, int min, int max) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = min + random.nextInt(max - min + 1);
        }
        return result;
    }
}
