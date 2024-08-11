package org.example;
import java.util.HashMap;
import java.util.Map;

public class OneAway {
    public static boolean oneAway(String s1, String s2) {
        // If the lengths of these strings differ by more then one,
        // they are not one edit away.
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        // We are allowed three operations
        // insert a character
        // remove a character
        // replace a character
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int difference = 0;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                difference++;
            }
            else {
                if (entry.getValue() != map2.get(entry.getKey())) {
                    difference++;
                }
            }

            if (difference > 1) {
                return false;
            }
        }

        return true;
    }


    // Sample solution 1
    public boolean oneEditAwaySample1(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        }
        else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        }
        else if (first.length() - 1 == second.length()) {
            return oneEditInsert(first, second);
        }
        return false;
    }

    private boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }

        return true;
    }

    // Check if you can insert a character into s1 to make s2.
    private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            }
            else {
                index1++;
                index2++;
            }
        }
        return true;
    }


    // Sample solution 2
    public boolean oneEditAwaySample2(String first, String second) {
        // Length checks
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        // Get shorter and longer string.
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                // Ensure that this is the first difference found.
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                if (index1 != index2) {
                    index1++;
                }
            }
            else {
                index1++;
            }
            index2++;
        }

        return true;
    }
}
