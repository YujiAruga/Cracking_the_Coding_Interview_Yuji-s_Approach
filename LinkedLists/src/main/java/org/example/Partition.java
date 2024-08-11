package org.example;

public class Partition {
    public static Node partition(Node root, int k) {
        if (root == null) {
            return null;
        }

        Node leftPartition = new Node(-1);
        Node rightPartition = new Node(-1);
        Node temp = rightPartition;
        Node answer = leftPartition;

        while (root != null) {
            if (root.val < k) {
                leftPartition.next = root;
            }
            else {
                rightPartition.next = root;
            }
            root = root.next;
        }

        leftPartition.next = temp.next;

        return answer.next;
    }
}
