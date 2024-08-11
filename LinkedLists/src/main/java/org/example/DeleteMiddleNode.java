package org.example;

public class DeleteMiddleNode {
    public static void deleteMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;
        Node prev = slow;
        while (fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;

        }

        prev.next = slow.next;
    }
}
