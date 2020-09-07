package org.example.QuickSort;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
    private void quickSort(List<Integer> toSort, int leftIndex, int rightIndex) {

        int leftNumber = leftIndex;
        int rightNumber = rightIndex;

        while (toSort.get(leftNumber) < toSort.get(leftIndex + (rightIndex - leftIndex) / 2)) {
            leftNumber++;
        }

        while (toSort.get(rightNumber) > toSort.get(leftIndex + (rightIndex - leftIndex) / 2)) {
            rightNumber--;
        }

        int temporaryLeft = toSort.get(leftNumber);
        int temporaryRight = toSort.get(rightNumber);
        toSort.set(leftNumber, temporaryRight);
        toSort.set(rightNumber, temporaryLeft);
        leftNumber++;
        rightNumber--;


        if (leftIndex < rightNumber) {
            quickSort(toSort, leftIndex, rightNumber);
        }
        if (leftNumber < rightIndex) {
            quickSort(toSort, leftNumber, rightIndex);
        }
    }

    public void sort(List<Integer> toSort) {
        if (toSort == null) throw new IllegalArgumentException();
        if (toSort.size() == 0) return;
        quickSort(toSort, 0, toSort.size() - 1);
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 6, 5, 2, 3, 1, 4, 7, 9, 8);

        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
