package org.example;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    public boolean checkPermutation(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            mapA.put(a.charAt(i), mapA.getOrDefault(a.charAt(i), 0) + 1);
            mapB.put(b.charAt(i), mapB.getOrDefault(b.charAt(i), 0) + 1);
        }

        if (mapA.equals(mapB)) return true;

        return false;
    }

    public boolean checkPermutationSample1(String a, String b) {
        if (a.length() != b.length()) return false;
        return sort(a).equals(sort(b));
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }

    public boolean checkPermutationSample2(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < a.length(); i++) {
            letters[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            letters[b.charAt(i)]--;
            if (letters[b.charAt(i)] < 0) return false;
        }

        return true; // letters has no negative values, and therefore no positive values either
    }
}
