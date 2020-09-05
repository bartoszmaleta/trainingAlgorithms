package org.example.FlatteningMultidemensionalList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class ListFlatter {
    private static Stream<Object> flatten(Object[] array) {
        return Arrays.stream(array)
                .flatMap(o -> o instanceof Object[]? flatten((Object[])o): Stream.of(o));
    }

    public static void main(String[] args) {

        Object[] objects;
        objects = new Object[]{1, 3, new Object[]{"age", 5}, "Kraków", new Object[]{1, new Object[]{3, new Object[]{4, 5}, "codecool"}, 6, 7}};

//        objects = new Object[]{1, 3, "codecool", 5, 8};
        System.out.println("object = " + Arrays.toString(objects));
        System.out.println("flatten objects as stream = "
                + Arrays.toString(flatten(objects).toArray()));


        System.out.println("\n=================================================\n");
        objects = new Object[]{1, 3, "codecool", 5, 8};
        System.out.println("object = " + Arrays.toString(objects));
        System.out.println("flatten objects as stream = "
                + Arrays.toString(flatten(objects).toArray()));

    }
}
