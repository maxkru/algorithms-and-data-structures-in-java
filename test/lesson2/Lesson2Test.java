package lesson2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lesson2Test {

    MyArray testArray;

    @Before
    public void initializeAndFillWithRandom() {
        testArray = new MyArray(10000);
        testArray.fillRandom();
    }

    private static boolean isSorted(MyArray array) {
        for (int i = 1; i < array.getSize(); i++) {
            if (array.get(i - 1) > array.get(i))
                return false;
        }
        return true;
    }

    @Test
    public void testSortBubble() {
        testArray.sortBubble();
        Assert.assertTrue(isSorted(testArray));
    }

    @Test
    public void testSortInsert() {
        testArray.sortInsert();
        Assert.assertTrue(isSorted(testArray));
    }

    @Test
    public void testSortSelect() {
        testArray.sortSelect();
        Assert.assertTrue(isSorted(testArray));
    }

    @Test
    public void testSortMerge() {
        testArray.sortMerge();
        Assert.assertTrue(isSorted(testArray));
    }
}
