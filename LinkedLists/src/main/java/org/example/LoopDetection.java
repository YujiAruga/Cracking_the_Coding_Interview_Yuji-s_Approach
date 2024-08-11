package org.example;

public class LoopDetection {
    public static Node loopDetection(Node root) {
        if (root == null || root.next == null) {
            return null;
        }

        Node fast = root;
        Node slow = root;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                fast = root;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null) {
            return null;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
