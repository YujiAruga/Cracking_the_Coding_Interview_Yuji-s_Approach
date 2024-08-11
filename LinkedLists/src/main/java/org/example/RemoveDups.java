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

        if (prev.val == root.val) {
            prev.next = null;
        }

        return root;
    }
}
