package org.example.Tries.Contacts;

import org.example.BinarySearchTree.NodeOfBST;
import org.w3c.dom.Node;

public class NodeOfContact {
    private static final int NUMBER_OF_CHARACTERS = 26;
    NodeOfContact[] children = new NodeOfContact[NUMBER_OF_CHARACTERS];
    int size = 0;

    private static int getCharIndex(char c) {
        return c - 'a';
//        It is just to get the index of a character in the children[ ] array.
//        children[ ] array is of size 26 (number of characters 'a' to 'z').
//        Java works on unicode characters concept, and since 'a' has an ASCII
//        value of 65 (return type of getCharIndex(char c) is int,
//        so it automatically converts character to its ascii value)
//        and we have to place it at children[0.....25], so we do, ascii
//        value of(c) - ascii value of('a').
    }
    private NodeOfContact getNodeOfContact(char c) {
        return children[getCharIndex(c)];
    }

    private void setNodeOfContact(char c, NodeOfContact nodeOfContact) {
        children[getCharIndex(c)] = nodeOfContact;
    }

    private void add (String s) {
        add(s, 0);
    }

    private void add (String s, int index) {
        size++;
        if (index == s.length()) return;
        char current = s.charAt(index);
        int charCode = getCharIndex(current);
        NodeOfContact child = getNodeOfContact(current);
        if (child == null) {
            child = new NodeOfContact();
            setNodeOfContact(current, child);
        }
        child.add(s, index + 1);
    }

    public int findCount(String s, int index) {
        if (index == s.length()) return size;
        NodeOfContact child = getNodeOfContact(s.charAt(index));
        if (child == null) return 0;
        return child.findCount(s, index + 1);

    }

}
