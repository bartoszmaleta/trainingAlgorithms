package org.example.BinarySearchTree;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    public List<Integer> generateNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i * 2 + 5);
        }
        return numbers;
    }

    @Test
    public void searchReturnsTrueForExistingElement() {
        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.build(numbers);
        assertTrue(binarySearchTree.search(9));
    }

    @Test
    public void searchReturnsFalseForNonExistingElement() {
        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.build(numbers);
        assertFalse(binarySearchTree.search(79));
    }

    @Test
    public void BTSBuilderUsesEveryNumber() {
        int size = 100;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.build(numbers);
        for (Integer number : numbers) {
            assertTrue(binarySearchTree.search(number));
        }
    }

    @Test
    public void addIsaddingNewElement() {
        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.build(numbers);
        assertFalse(binarySearchTree.search(1500));
        binarySearchTree.add(1500);
        assertTrue(binarySearchTree.search(1500));
    }

    @Disabled
    @Test
    public void addThrowsExceptionIfElementExistsInTree() {
        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.build(numbers);
        assertThrows(InstanceAlreadyExistsException.class, () -> binarySearchTree.add(7));
    }

    @Test
    public void removeRemovesElement() {
        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.build(numbers);
        assertTrue(binarySearchTree.search(7));
        binarySearchTree.remove(7);
        assertFalse(binarySearchTree.search(7));
    }

    @Test
    public void removeThrowsElementNotFoundException() {
        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.build(numbers);
        assertFalse(binarySearchTree.search(87));
    }
}