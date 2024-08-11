package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPermutationTest {
    @Test
    void checkPermutation() {
        CheckPermutation checkPermutation = new CheckPermutation();
        assertEquals(checkPermutation.checkPermutation("abc", "def"), false);
        assertNotEquals(checkPermutation.checkPermutation("abc", "def"), true);
    }

    @Test
    void abcdefIsPermutationOffedcba() {
        CheckPermutation checkPermutation = new CheckPermutation();
        assertEquals(checkPermutation.checkPermutation("abcdef", "fedcba"), true);
    }

}