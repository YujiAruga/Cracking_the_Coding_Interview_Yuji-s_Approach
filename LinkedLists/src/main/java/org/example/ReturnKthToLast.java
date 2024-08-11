package org.example;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReturnKthToLast {
    public static int returnKthToLast(ListNode head, int k) {
        int count = 0;
        while (count < k && head != null) {
            count++;
            head = head.next;
        }

        if (count == k) {
            ListNode temp = head;
            while (head != null) {
                head = head.next;
                temp = temp.next;
            }
            return temp.val;
        }
        else {
            return -1;
        }
    }
}
