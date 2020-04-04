package lesson2;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        int[] sizeSet = {10, 100, 500, 1000, 5000, 10000, 50000, 100000, 200000, 500000, 1000000};

        Thread.sleep(1000);

        for (int size : sizeSet) {
            System.out.println(size + " elements");

            MyArray array = new MyArray(size);
            array.fillRandom();

            testSort(array, "Bubble");
            testSort(array, "Select");
            testSort(array, "Insert");
            testSort(array, "Merge");

            System.out.println("===============");
        }
    }

    private static void testSort(MyArray array, String sortName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyArray arrayCopy = array.copy();
        long start = System.currentTimeMillis();
        MyArray.class.getMethod("sort" + sortName).invoke(arrayCopy);
        long duration = System.currentTimeMillis() - start;
        System.out.println(sortName + " sort: " + duration + " ms");
    }
}