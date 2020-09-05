package org.example.FlatteningMultidemensionalList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerArrayFlattener {
    public static Integer[] flatten(Object[] inputArray) throws IllegalArgumentException {

        if (inputArray == null) return null;

        List<Integer> flatList = new ArrayList<>();

        for (Object element : inputArray) {
            if (element instanceof Integer) {
                flatList.add((Integer) element);
            } else if (element instanceof Object[]) {
                flatList.addAll(Arrays.asList(flatten((Object[]) element)));
            } else {
                throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
            }
        }
        return flatList.toArray(new Integer[flatList.size()]);
    }
}
