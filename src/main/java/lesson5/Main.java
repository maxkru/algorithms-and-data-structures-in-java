package lesson5;

import lesson5.util.IntegerBinarySearch;
import lesson5.util.Math;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 9));

        int[] arr = Math.generateRandomArray(30, -10, 10);
        Arrays.sort(arr);
        try {
            System.out.println(IntegerBinarySearch.find(arr, 1).getIndex());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
