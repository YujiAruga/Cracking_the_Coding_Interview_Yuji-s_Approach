package org.example;

public class SumLists {
    public static Node sumLists(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node answer = head1;
        int sum = head1.val + head2.val;
        int carry = sum / 10;
        int digit = sum % 10;
        head1.val = digit;
        head1 = head1.next;
        head2 = head2.next;
        while (head1 != null && head2 != null) {
            sum = head1.val + head2.val + carry;
            carry = sum / 10;
            digit = sum % 10;
            head1.val = digit;
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1 != null) {
            sum = head1.val + carry;
            carry = sum / 10;
            digit = sum % 10;
            head1.val = digit;
            head1 = head1.next;
        }

        while (head2 != null) {
            sum = head2.val + carry;
            carry = sum / 10;
            digit = sum % 10;
            head2.val = digit;
            head2 = head2.next;
        }

        return answer;
    }
}
