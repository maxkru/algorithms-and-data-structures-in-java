package lesson2;

import java.util.Arrays;

public class MyArray {
    private int[] arr;
    private int size;


    public MyArray(int[] arr) {
        this.arr = arr.clone();
        size = arr.length;
    }

    public MyArray(int size) {
        arr = new int[size];
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public boolean delete(int value) {
        boolean deleted = false;

        int i;
        for (i = 0; i < size; i++) {
            if (arr[i] == value) {
                shiftLeft(i);
                deleted = true;
            }
        }
        return deleted;
    }

    private void shiftLeft(int index) {
        if (size - 1 - index >= 0) System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
        size--;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, size));
    }

    public void sortBubble() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1])
                    exchange(j, j+1);
            }
        }
    }

    private void exchange(int i1, int i2) {
        int t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }

    public void sortSelect() {
        int marker;
        for (int i = 0; i < size; i++) {
            marker = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[marker])
                    marker = j;
            }
            exchange(marker, i);
        }
    }

    public void sortInsert(){
        for(int i = 1; i < size; i++){
            int t = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (arr[j - 1] >= t) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = t;
        }
    }

    public void fillRandom() {
        for (int i = 0; i < size; i++) {
            set(i, (int) (Integer.MAX_VALUE * (Math.random() - 0.5)));
        }
    }

    public MyArray copy() {
        return new MyArray(arr);
    }

    public void sortMerge() {
        sortMerge(arr.clone(), arr, 0, size - 1);
    }

    private void sortMerge(int[] src, int[] dest, int left, int right) {
        if (left == right) {
            return;
        }

        int middle = (left + right) / 2;
        sortMerge(dest, src, left, middle);
        sortMerge(dest, src, middle + 1, right);

        int leftCurr = left;
        int rightCurr = middle + 1;
        for (int i = left; i <= right; i++) {
            if (leftCurr <= middle && rightCurr <= right) {
                if (src[leftCurr] < src[rightCurr]) {
                    dest[i] = src[leftCurr];
                    leftCurr++;
                } else {
                    dest[i] = src[rightCurr];
                    rightCurr++;
                }
            } else if (leftCurr <= middle) {
                dest[i] = src[leftCurr];
                leftCurr++;
            } else {
                dest[i] = src[rightCurr];
                rightCurr++;
            }
        }
    }
}
