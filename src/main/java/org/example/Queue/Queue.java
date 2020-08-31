package org.example.Queue;

public class Queue {
    private static class NodeOfQueue {
        private final int data;
        private NodeOfQueue next;
        private NodeOfQueue(int data) {
            this.data = data;
        }
    }

    private NodeOfQueue head;
    private NodeOfQueue tail;

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void add(int data) {
        NodeOfQueue nodeOfQueue = new NodeOfQueue(data);
        if (tail != null) {
            tail.next = nodeOfQueue;
        }
        tail = nodeOfQueue;
        if (head == null) {
            head = nodeOfQueue;
        }
    }

    public int remove() {
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
}
