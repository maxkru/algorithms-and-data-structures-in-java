package lesson5.util;

import java.util.NoSuchElementException;

public class IntegerBinarySearch {

    public static class IntegerSearchResult {
        private final boolean isFound;
        private final int index;

        private IntegerSearchResult(boolean isFound, int index) {
            this.isFound = isFound;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public boolean isFound() {
            return isFound;
        }

    }

    public static IntegerSearchResult find(int[] arr, int t) {
        int result = findInternal(arr, t, 0, arr.length - 1);
        if (result == -1)
            throw new NoSuchElementException();
//            return new IntegerSearchResult(false, -1);
        return new IntegerSearchResult(true, result);
    }

    private static int findInternal(int[] arr, int t, int iLow, int iHigh) {
        int iMid = (iLow + iHigh) / 2;
        if (arr[iMid] == t)
            return iLow;
        if (iLow > iHigh)
            return -1;
        if (arr[iMid] < t)
            return findInternal(arr, t, iMid + 1, iHigh);
        return findInternal(arr, t, iLow, iMid - 1);

    }
}
