package org.example.Stack;


import javax.xml.crypto.NodeSetData;

public class Stack {
    private static class NodeOfStack {
        private final int data;
        private NodeOfStack next;
        private NodeOfStack(int data) {
            this.data = data;
        }
    }

    private NodeOfStack top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        return top.data;
    }

    public void push(int data) {
        NodeOfStack nodeOfStack = new NodeOfStack(data);
        nodeOfStack.next = top;
        top = nodeOfStack;
    }

    public int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }
}
