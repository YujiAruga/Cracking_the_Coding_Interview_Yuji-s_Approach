package org.example;

public class Palindrome {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Preserve the beginning of the LinkedList
        Node root = head;


        // Copy the whole linkedList
        Node copied = new Node(head.val);
        Node start = copied;
        head = head.next;
        while (head != null) {
            copied.next = new Node(head.val);
            copied = copied.next;
            head = head.next;
        }

        // Reverse the copied linkedList
        Node prev = null;
        prev.next = start;
        Node then = start.next;
        while (then != null) {
            start.next = prev;
            prev = start;
            start = then;
            then = then.next;
        }

        start.next = prev;
        prev = start;

        while (prev != null) {
            if (prev.val != root.val) {
                return false;
            }
            prev = prev.next;
            root = root.next;
        }

        return true;
    }
}
