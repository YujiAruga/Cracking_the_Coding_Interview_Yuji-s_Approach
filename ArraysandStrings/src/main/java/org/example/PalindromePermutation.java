package org.example;
import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char lowerchar = Character.toLowerCase(c);
            map.put(lowerchar, map.getOrDefault(lowerchar, 0) + 1);
        }

        // Palindrome can contain one odd number of char or every char is
        // even number.
        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == ' ') {
                continue;
            }

            if (entry.getValue() % 2 == 1) {
                odd++;
            }

            if (odd > 1) {
                return false;
            }
        }

        return true;
    }


    // Sample solution 1
    public boolean canPermutePalindromeSample(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /*
    Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
    This is case insensitive. Non-letter characters map to -1.
     */
    private int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && z <= val) {
            return val - a;
        }
        return -1;
    }

    /* Count how many times each character appears */
    int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') -
                              Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }


    // Sample solution 2
    public boolean canPermutePalindromeSample2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') -
                              Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                }
                else {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;
    }


    // Sample solution 3
    /* Toggle the ith bit in the integer */
    private int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        bitVector ^= mask;
        return bitVector;
    }

    /*
    Create bit vector for string. For each letter with value i,
    toggle the ith bit.
     */
    private int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    /*
    Check that at most one bit is set by subtracting one from the
    integer and ANDing it with the original integer.
     */
    private boolean checkAtMostOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    public boolean isPermutePalindromeSample3(String phrase) {
        int bitVector = createBitVector(phrase);
        return checkAtMostOneBitSet(bitVector);
    }

}
