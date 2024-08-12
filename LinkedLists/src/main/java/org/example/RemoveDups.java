package org.example;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
    public static Node removeDups(Node root) {
        if (root == null) {
            return null;
        }

        if (root.next == null) {
            return root;
        }

        Node prev = root;
        Node curr = root.next;
        Set<Integer> set = new HashSet<>();
        set.add(prev.val);

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
                curr = curr.next;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }

//        if (prev.val == root.val) {
//            prev.next = null;
//        }

        return root;
    }


    // Sample solution 1
    public void deleteDupsSample1(Node root) {
        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        while (root != null) {
            if (set.contains(root.val)) {
                prev.next = root.next;
            }
            else {
                set.add(root.val);
                prev = root;
            }
            root = root.next;
        }
    }


    // Sample solution 2
    public void deleteDupsSample2(Node root) {
        Node curr = root;
        while (curr != null) {
            // Remove all future nodes that have the same value
            Node runner = curr;
            while (runner.next != null) {
                if (runner.next.val == curr.val) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }

}
