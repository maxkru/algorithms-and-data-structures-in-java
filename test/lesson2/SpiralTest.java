package lesson2;

import org.junit.Assert;
import org.junit.Test;

public class SpiralTest {

    @Test
    public void test5() {
        int[][] expected = {
                { 1,  2,  3,  4,  5},
                {16, 17, 18, 19,  6},
                {15, 24, 25, 20,  7},
                {14, 23, 22, 21,  8},
                {13, 12, 11, 10,  9}
        };
        Assert.assertArrayEquals(expected, Spiral.makeSpiral(5));
    }

    @Test
    public void test4() {
        int[][] expected = {
                {1,   2,  3,  4},
                {12, 13, 14,  5},
                {11, 16, 15,  6},
                {10,  9,  8,  7}
        };
        Assert.assertArrayEquals(expected, Spiral.makeSpiral(4));
    }
}
