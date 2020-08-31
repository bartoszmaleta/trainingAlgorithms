package org.example.LinkedList;

public class LinkedList {
    NodeOfLinkedList head;

    public void append(int data) {
        if (head == null) {
            head = new NodeOfLinkedList(data);
            return;
        }
        NodeOfLinkedList current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new NodeOfLinkedList(data);
    }

    public void prepend(int data) {
        NodeOfLinkedList newHEad = new NodeOfLinkedList(data);
        newHEad.next = head;
        head = newHEad;
    }

    public void deleteWithValue(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        NodeOfLinkedList current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
