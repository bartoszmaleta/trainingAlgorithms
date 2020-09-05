package org.example.FlatteningMultidemensionalList;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayFlattenerTest {
    Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testNullReturnsNull() throws IllegalArgumentException {
        Assert.assertNull(
                "Testing a null argument",
                IntegerArrayFlattener.flatten(null)
        );
    }

    @Test
    public void testEmptyArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing an empty array",
                new Integer[]{},
                IntegerArrayFlattener.flatten(new Object[]{})
        );
    }

    @Test
    public void testFlatArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing a flat array",
                expectedArray,
                IntegerArrayFlattener.flatten(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
        );
    }

    @Test
    public void testNestedArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing nested array",
                expectedArray,
                IntegerArrayFlattener.flatten(new Object[]{1, 2, 3, 4, new Object[]{5, 6, 7, 8}, 9, 10})
        );
    }

    @Test
    public void testMultipleNestedArrays() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing multiple nested arrays",
                expectedArray,
                IntegerArrayFlattener.flatten(new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10})
        );
    }

    @Test
    public void throwsExceptionForObjectInArray() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IntegerArrayFlattener.flatten(
                    new Object[]{new Object()}
            );
        });
    }

    @Test
    public void throwsExceptionForObjectInNestedArray() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IntegerArrayFlattener.flatten(
                    new Object[]{1, 2, new Object[]{3, new Object()}}
            );
        });
    }

    @Test
    public void throwsExceptionForNullInArray() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IntegerArrayFlattener.flatten(
                    new Object[]{null}
            );
        });
    }

    @Test
    public void throwsExceptionForNullInNestedArray() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IntegerArrayFlattener.flatten(
                    new Object[]{1, 2, new Object[]{3, null}}
            );
        });
    }
}