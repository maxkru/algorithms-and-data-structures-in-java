package lesson5.util;

public class Math {

    public static long pow(long a, int b) {
        if (b == 1)
            return a;
        if (b % 2 == 0)
            return pow(a * a, b / 2);
        return a * pow(a, b - 1);
    }
}
