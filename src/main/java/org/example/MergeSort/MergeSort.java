package org.example.MergeSort;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        if (array.length <= 1) {
            return array;
        }

        int midpoint = array.length / 2;

        int[] left = new int[midpoint];
        int[] right;

        if (array.length % 2 == 0) { // if array.length is an even number.
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }

        for (int i = 0; i < midpoint; i++) {
            left[i] = array[i];
        }

        System.arraycopy(array, midpoint, right, 0, right.length);

        // SAME EFFECT
//        for (int j = 0; j < right.length; j++) {
//            right[j] = array[midpoint + j];
//        }

        int[] result;

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);

        return result;
    }

    // Merges the left and right array in ascending order.
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer] = left[leftPointer];
                    resultPointer++;
                    leftPointer++;
                } else {
                    result[resultPointer] = right[rightPointer];
                    resultPointer++;
                    rightPointer++;
                }
            }
            else if (leftPointer < left.length) {
                result[resultPointer] = left[leftPointer];
                resultPointer++;
                leftPointer++;
            }
            else if (rightPointer < right.length) {
                result[resultPointer] = right[rightPointer];
                resultPointer++;
                rightPointer++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] array = {5, 4, 3, 2, 1};
        System.out.println("Initial Array: ");
        printArray(array);

        array = mergeSort(array);
        System.out.println("Sorted Array: ");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
