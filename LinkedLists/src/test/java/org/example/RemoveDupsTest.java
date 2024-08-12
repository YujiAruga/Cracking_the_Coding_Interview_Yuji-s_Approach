package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDupsTest {

    @Test
    void removeDups1112345336() {
        RemoveDups removeDups = new RemoveDups();
        Node node = new Node(1);
        node.next = new Node(1);
        node = node.next;
        node.next = new Node(2);
        node = node.next;
        node.next = new Node(3);
        node = node.next;
        node.next = new Node(4);
        node = node.next;
        node.next = new Node(5);
        node = node.next;
        node.next = new Node(3);

        Node expected = new Node(1);
        expected.next = new Node(2);
        expected.next.next = new Node(3);
        expected.next.next.next = new Node(4);
        expected.next.next.next.next = new Node(5);
        assertEquals(removeDups.removeDups(node), expected);
    }
}