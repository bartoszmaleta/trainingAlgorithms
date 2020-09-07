package org.example.MergeSort;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sortingNullThrowsError() {
        MergeSort mergeSort = new MergeSort();
        assertThrows(IllegalArgumentException.class, ()-> mergeSort.mergeSort(null));
    }

    @Test
    void sortingSimpleItemsWorks() {
        MergeSort mergeSort = new MergeSort();

        int[] toSort = new int[] {5, 3, 1, 12, 9};
        int[] sorted = mergeSort.mergeSort(toSort);
        int[] expected = new int[] {1, 3, 5, 9, 12};

        Assert.assertArrayEquals(expected, sorted);
    }

    @Test
    void sortingDuplicateItemsWorks() {
        MergeSort mergeSort = new MergeSort();

        int[] toSort = new int[] {5, 3, 1, 5, 9};
        int[] sorted = mergeSort.mergeSort(toSort);
        int[] expected = new int[] {1, 3, 5, 5, 9};

        Assert.assertArrayEquals(expected, sorted);
    }
//
    @Test
    void sortingOneItemWorks() {
        MergeSort mergeSort = new MergeSort();

        int[] toSort = new int[] {2};
        int[] sorted = mergeSort.mergeSort(toSort);
        int[] expected = new int[] {2};

        Assert.assertArrayEquals(expected, sorted);
    }

}