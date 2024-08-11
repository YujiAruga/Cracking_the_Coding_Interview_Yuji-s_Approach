package org.example;

import java.util.Arrays;

public class IsUnique {
    public boolean isUnique(String word) {
        // I should have checked string was an ASCII or a Unicode
        if (word.length() > 26) return false;
        char[] chars = word.toCharArray(); // Additional data structure
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) return false;
        }

        return true;
    }

    public boolean isUniqueSample1(String word) {
        if (word.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }

        return true;
    }

    public boolean isUniqueSample2(String word) {
        int checker = 0;
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }

        return true;
    }


}
