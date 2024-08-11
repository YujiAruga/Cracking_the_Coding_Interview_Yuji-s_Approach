package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutationTest {

    @Test
    void isTacocatPermutationOfPalindrome() {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        assertEquals(palindromePermutation.canPermutePalindrome("Tact Coa"), true);
    }

}