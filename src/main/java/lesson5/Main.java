package lesson5;

import lesson5.sack.Item;
import lesson5.sack.Sack;
import lesson5.util.IntegerBinarySearch;
import lesson5.util.Math;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 9));

        int[] arr = Math.generateRandomArray(30, -10, 10);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        try {
            System.out.println(IntegerBinarySearch.find(arr, 1).getIndex());
        } catch (Throwable e) {
            e.printStackTrace();
        }

        LinkedList<Item> items = new LinkedList<>();
        items.add(new Item(100, 1000));
        items.add(new Item(250, 2500));
        items.add(new Item(300, 3000));
        Sack sack = new Sack(350);
        System.out.println(sack.bestValue(items));
    }

}
