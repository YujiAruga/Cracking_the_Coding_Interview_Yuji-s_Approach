package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReturnKthToLastTest {

    @Test
    void returnKthToLast12345k3() {
        ReturnKthToLast returnKthToLast = new ReturnKthToLast();
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        assertEquals(returnKthToLast.returnKthToLast(head, 3), new ListNode(3));
    }

}