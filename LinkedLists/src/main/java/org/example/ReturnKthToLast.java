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


    // Sample solution 1
    public int printKthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }

        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.val);
        }
        return index;
    }



    // Sample solution 3
    class Index {
        public int value = 0;
    }

    ListNode kthToLast(ListNode head, int k) {
        Index index = new Index();
        return kthToLast(head, k, index);
    }

    ListNode kthToLast(ListNode head, int k, Index idx) {
        if (head == null) {
            return null;
        }

        ListNode node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k) {
            return head;
        }
        return node;
    }



    // Sample solution 4
    public ListNode nthToLast(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        // Move p1 k nodes into the list.
        for (int i = 0; i < n; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        // Move them at the same pace. When p1 hits the end,
        // p2 will be at the right element.
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
