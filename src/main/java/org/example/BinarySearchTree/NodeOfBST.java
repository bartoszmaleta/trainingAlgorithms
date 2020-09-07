package org.example.BinarySearchTree;

public class NodeOfBST {

    private Integer value;
    private NodeOfBST left;
    private NodeOfBST right;

    public NodeOfBST(Integer value) {
        this.value = value;
        left = null;
        right = null;
    }

    public Integer getValue() {
        return value;
    }

    public NodeOfBST setValue(Integer value) {
        this.value = value;
        return this;
    }

    public NodeOfBST getLeft() {
        return left;
    }

    public NodeOfBST setLeft(NodeOfBST left) {
        this.left = left;
        return this;
    }

    public NodeOfBST getRight() {
        return right;
    }

    public NodeOfBST setRight(NodeOfBST right) {
        this.right = right;
        return this;
    }

    @Override
    public String toString() {
        return "NodeOfBST{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
