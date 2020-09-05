package org.example.BinarySearch;

public class BinarySearch {
    public int binarySearch(int[] arr, int rangeStart, int rangeEnd, int numberToFound) {
        if (rangeEnd >= rangeStart) {
            int mid = rangeStart + (rangeEnd - rangeStart) / 2;
            if (arr[mid] == numberToFound) {
                return mid;
            }
            if (arr[mid] > numberToFound) {
                return binarySearch(arr, rangeStart, mid - 1, numberToFound);
            }
            return binarySearch(arr, mid + 1, rangeEnd, numberToFound);
        }
        return -1;
    }

    public boolean binarySearchBoolean(int indexOfFoundedOrNotElement) {
        return indexOfFoundedOrNotElement > -1;
    }

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int[] arr = { 2, 3, 4, 10, 40 };
        int arrayLength = arr.length;
        int numberToBeFound = 3;
        int result = ob.binarySearch(arr, 0, arrayLength - 1, numberToBeFound);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);

//      arr[] = { 2, 3, 4, 10, 40 };
//      arrayLength = arr.length;
        numberToBeFound = 50;
        boolean resultBool = ob.binarySearchBoolean(ob.binarySearch(arr, 0, arrayLength  - 1, numberToBeFound));
        System.out.println(resultBool);

        numberToBeFound = 10;
        resultBool = ob.binarySearchBoolean(ob.binarySearch(arr, 0, arrayLength  - 1, numberToBeFound));
        System.out.println(resultBool);
    }
}
